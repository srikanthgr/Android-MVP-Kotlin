package com.srikanth.androidmvpkotlin.presentation.views.viewmodels

import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.AnswerViewModel
import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.QuestionViewModel

data class DetailsViewModel(
        val questions: List<QuestionViewModel>,
        val answers: List<AnswerViewModel>,
        val favorites: List<QuestionViewModel>)