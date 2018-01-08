package com.srikanth.androidmvpkotlin.domain

import com.srikanth.androidmvpkotlin.model.entities.UserListModel
import com.srikanth.androidmvpkotlin.model.repositories.UserRepository
import com.srikanth.androidmvpkotlin.views.viewmodels.UserViewModel
import io.reactivex.Single


class GetUsers(private val userRespository: UserRepository) {
    fun execute(page: Int, forced: Boolean): Single<List<UserViewModel>> {
        val usersList = userRespository.getUsers(page, forced)
        return usersList.map { userListModel: UserListModel? ->
            val items = userListModel?.items ?: emptyList()
            items.map { UserViewModel(it.userId, it.displayName, it.reputation, it.profileImage) }
        }
    }
}