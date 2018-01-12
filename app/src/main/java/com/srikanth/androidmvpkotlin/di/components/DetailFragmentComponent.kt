package com.srikanth.androidmvpkotlin.di.components

import com.srikanth.androidmvpkotlin.di.modules.DetailsFragmentModule
import com.srikanth.androidmvpkotlin.presentation.presenters.DetailPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(DetailsFragmentModule::class))
interface DetailFragmentComponent {
    fun presenter() : DetailPresenter
}