package com.srikanth.androidmvpkotlin.presentation.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.srikanth.androidmvpkotlin.R
import com.srikanth.androidmvpkotlin.di.modules.UserListFragmentModule
import com.srikanth.androidmvpkotlin.presentation.presenters.UserListPresenter
import com.srikanth.androidmvpkotlin.presentation.views.UserListView
import com.srikanth.androidmvpkotlin.presentation.views.activities.MainActivity
import com.srikanth.androidmvpkotlin.presentation.views.adapters.UserListAdapter
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.UserViewModel
import com.srikanth.androidmvpkotlin.utils.app
import kotlinx.android.synthetic.main.fragment_user_list.*


class UserListFragment : Fragment(), UserListView {

    private val component by lazy { app.component.plus(UserListFragmentModule()) }
    private val presenter: UserListPresenter by lazy { component.presenter() }
    private val adapter by lazy {
        val userList = mutableListOf<UserViewModel>()
        UserListAdapter(userList) { user, view ->
            openDetailFragment(user, view)
        }
    }

    private lateinit var layoutManager: LinearLayoutManager

    private fun openDetailFragment(user: UserViewModel, view: View) {
        val detailsFragment = DetailsFragment.newInstance(user)
        (activity as MainActivity).addDetailsFragmentWithTransition(detailsFragment)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initAdapter()

        presenter.attachView(this)

        if (adapter.itemCount == 0) {
            showLoading()
            presenter.getUsers()
        }
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(app)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition() + layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                presenter.onScrollChanged(lastVisibleItemPosition, totalItemCount)
            }
        })
    }

    private fun initViews() {
        swipeRefreshLayout.setOnRefreshListener {
            presenter.getUsers(true)
        }
    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun addUserToList(user: List<UserViewModel>) {
        val adapter = recyclerView.adapter as UserListAdapter
        adapter.addUsers(user)
    }

    override fun showError() {
        //Toast.makeText(app, "Couldn't load data", Toast.LENGTH_SHORT).show()
    }

    override fun clearList() {
        adapter.clearUsers()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}