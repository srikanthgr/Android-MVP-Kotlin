package com.srikanth.androidmvpkotlin.presentation.views.fragments

import android.support.v4.app.Fragment
import com.srikanth.androidmvpkotlin.di.modules.DetailsFragmentModule
import com.srikanth.androidmvpkotlin.presentation.views.DetailView
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.DetailsViewModel
import com.srikanth.androidmvpkotlin.utils.app


class DetailsFragment: Fragment(), DetailView {

    private val component by lazy { app.component.plus(DetailsFragmentModule())}

    private val presenter by lazy { component.presenter() }

    private val detailsAdapter by lazy {  }
    override fun showDetails(details: DetailsViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}