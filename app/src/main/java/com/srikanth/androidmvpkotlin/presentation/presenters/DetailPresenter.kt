package com.srikanth.androidmvpkotlin.presentation.presenters

import com.srikanth.androidmvpkotlin.domain.GetDetails
import com.srikanth.androidmvpkotlin.presentation.views.DetailView
import com.srikanth.androidmvpkotlin.utils.SchedulerProvider


class DetailPresenter(private val details: GetDetails, private val schedulerProvider: SchedulerProvider) : BasePresenter<DetailView>() {
    fun getDetails(id: Long, forced: Boolean = false) {
        view?.showLoading()
    }
}