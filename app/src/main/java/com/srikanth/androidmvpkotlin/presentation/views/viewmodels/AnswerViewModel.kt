package com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels

import com.srikanth.androidmvpkotlin.presentation.views.adapters.AdapterConstants
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType


data class AnswerViewModel(
        val answerId: Long,
        val score: Long,
        val accepted: Boolean,
        val questionTitle: String) : ViewType {

    override fun getViewType() = AdapterConstants.ANSWER
}