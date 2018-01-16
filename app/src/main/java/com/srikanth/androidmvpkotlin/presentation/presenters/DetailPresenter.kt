package com.srikanth.androidmvpkotlin.presentation.presenters

import com.srikanth.androidmvpkotlin.domain.GetDetails
import com.srikanth.androidmvpkotlin.presentation.views.DetailView
import com.srikanth.androidmvpkotlin.utils.SchedulerProvider
import io.reactivex.schedulers.Schedulers


class DetailPresenter(private val details: GetDetails, private val schedulerProvider: SchedulerProvider) : BasePresenter<DetailView>() {
    fun getDetails(id: Long, forced: Boolean = false) {
        view?.showLoading()
        details.execute(id, forced).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe({ detailsModel ->
            view?.hideLoading()
            view?.showDetails(detailsModel)

        }, { error ->
            view?.hideLoading()
            view?.showError(error.localizedMessage)
        })
    }
}