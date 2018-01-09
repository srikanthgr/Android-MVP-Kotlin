package com.srikanth.androidmvpkotlin.model.repositories

import com.srikanth.androidmvpkotlin.model.entities.UserListModel
import com.srikanth.androidmvpkotlin.model.persistence.dao.UserDao
import com.srikanth.androidmvpkotlin.model.services.UserService
import com.srikanth.androidmvpkotlin.utils.CalendarWrapper
import com.srikanth.androidmvpkotlin.utils.ConnectionHelper
import com.srikanth.androidmvpkotlin.utils.Constants
import com.srikanth.androidmvpkotlin.utils.PreferencesHelper
import io.reactivex.Single
import io.reactivex.SingleEmitter


class DefaultUserRepository(private val userService: UserService,
                            private val userDao: UserDao,
                            private val connectionHelper: ConnectionHelper,
                            private val preferencesHelper: PreferencesHelper,
                            private val calendarWrapper: CalendarWrapper) : UserRepository {

    private val LAST_UPDATE_KEY = "last_update_page_"

    override fun getUsers(page: Int, forced: Boolean): Single<UserListModel> {
        return Single.create<UserListModel> { emitter: SingleEmitter<UserListModel> ->
          if (shouldUpdate(page, forced)) {
                loadUserFromNetwork(page, emitter)
            } else {
                loadOfflineUsers(page, emitter)
            }
        }
    }

    private fun shouldUpdate(page: Int, forced: Boolean) = when {
        forced -> true
        !connectionHelper.isOnline() -> false
        else -> {
            val lastUpdate = preferencesHelper.getLong(LAST_UPDATE_KEY + page)
            val currentTime = calendarWrapper.getCurrentTimeInMills()
            lastUpdate + Constants.REFRESH_LIMIT < currentTime
        }
    }

    private fun loadUserFromNetwork(page: Int, emitter: SingleEmitter<UserListModel>) {
        try {
            val users = userService.getUsers(page).execute().body()
            if (users != null) {
                userDao.insertAll(users.items)
                val currentTime = calendarWrapper.getCurrentTimeInMills()
                preferencesHelper.save(LAST_UPDATE_KEY + page, currentTime)
                emitter.onSuccess(users)
            } else {
                emitter.onError(Exception("No data received"))
            }
        } catch (exception: Exception) {
            emitter.onError(exception)
        }
    }

    private fun loadOfflineUsers(page: Int, emitter: SingleEmitter<UserListModel>) {
        val users = userDao.getUsers(page)
        if (!users.isEmpty()) {
            emitter.onSuccess(UserListModel(users))
        } else {
            emitter.onError(Exception("Device is offline"))
        }
    }
}