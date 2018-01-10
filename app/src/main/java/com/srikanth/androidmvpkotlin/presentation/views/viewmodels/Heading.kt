package com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels

import com.srikanth.androidmvpkotlin.presentation.views.adapters.AdapterConstants
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType


data class Heading(val title: String) : ViewType {
    override fun getViewType() = AdapterConstants.HEADING
}