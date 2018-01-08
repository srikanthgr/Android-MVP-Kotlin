package com.srikanth.androidmvpkotlin.model.repositories

import com.srikanth.androidmvpkotlin.model.entities.UserListModel
import io.reactivex.Single


interface UserRepository {
    fun getUsers(page: Int = 1, forced: Boolean = false): Single<UserListModel>
    /** Single either items Single Item or en error event **/
}