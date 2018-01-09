package com.srikanth.androidmvpkotlin.di.components

import com.srikanth.androidmvpkotlin.presentation.presenters.UserListPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(UserListFragmentModule::class))
interface UserListFragmentModule {
    fun presenter() : UserListPresenter
}