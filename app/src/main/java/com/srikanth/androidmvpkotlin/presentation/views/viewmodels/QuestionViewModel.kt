package com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels

import com.srikanth.androidmvpkotlin.presentation.views.adapters.AdapterConstants
import com.srikanth.androidmvpkotlin.presentation.views.adapters.ViewType


data class QuestionViewModel(
    val viewCount: Long,
    val score: Long,
    val title: String,
    val link: String,
    val questionId: Long) : ViewType {

        override fun getViewType(): Int = AdapterConstants.QUESTION
}