package com.srikanth.androidmvpkotlin.views

import com.srikanth.androidmvpkotlin.views.viewmodels.UserViewModel


interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUserToList(user: List<UserViewModel>)
    fun showError()
    fun clearList()
}