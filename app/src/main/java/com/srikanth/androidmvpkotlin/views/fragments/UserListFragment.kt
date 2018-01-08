package com.srikanth.androidmvpkotlin.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import com.srikanth.androidmvpkotlin.views.UserListView
import com.srikanth.androidmvpkotlin.views.viewmodels.UserViewModel


class UserListFragment : Fragment(), UserListView {

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addUserToList(user: List<UserViewModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}