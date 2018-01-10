package com.srikanth.androidmvpkotlin.presentation.views

import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.DetailsViewModel


interface DetailView {
    fun showDetails(details: DetailsViewModel)
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}