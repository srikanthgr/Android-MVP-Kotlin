package com.srikanth.androidmvpkotlin.presentation.presenters

import com.srikanth.androidmvpkotlin.domain.GetUsers
import com.srikanth.androidmvpkotlin.presentation.views.UserListView
import com.srikanth.androidmvpkotlin.utils.SchedulerProvider


class UserListPresenter(private val getUsers: GetUsers,
                        private val schedulerProvider: SchedulerProvider) : BasePresenter<UserListView>() {
    private val offset = 5

    private var page = 1

    private var loading = false

    fun getUsers(forced: Boolean = false) {
        loading = true
        val pageToRequest = if (forced) 1 else page
        getUsers.execute(pageToRequest, forced).
                subscribeOn(schedulerProvider.ioScheduler()).
                observeOn(schedulerProvider.uiScheduler()).
                subscribe({ users ->
                    loading = false
                    if (forced) {
                        resetPaging()
                    }
                    if (page == 1) {
                        view?.clearList()
                    }
                    view?.addUserToList(users)
                    view?.hideLoading()
                    page++
                },
                        {
                            loading = false
                            view?.showError()
                            view?.hideLoading()
                        })
    }

    private fun resetPaging() {
        page = 1
    }

    fun onScrollChanged(lastViewItemPosition: Int, totalItemCount: Int){
        if(!loading){
            if(lastViewItemPosition >= totalItemCount - offset){
                getUsers
            }
        }

        if(loading && lastViewItemPosition >= totalItemCount){
            view?.showLoading()
        }
    }
}

