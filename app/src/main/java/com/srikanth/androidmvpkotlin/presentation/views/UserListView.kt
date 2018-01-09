package com.srikanth.androidmvpkotlin.presentation.views

import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.UserViewModel


interface UserListView {
    fun showLoading()
    fun hideLoading()
    fun addUserToList(user: List<UserViewModel>)
    fun showError()
    fun clearList()
}