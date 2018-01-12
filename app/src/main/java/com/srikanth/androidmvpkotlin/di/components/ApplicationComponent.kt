package com.srikanth.androidmvpkotlin.di.components

import android.app.Application
import com.srikanth.androidmvpkotlin.di.modules.ApplicationModule
import com.srikanth.androidmvpkotlin.di.modules.DetailsFragmentModule
import com.srikanth.androidmvpkotlin.di.modules.UserListFragmentModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: Application)
    fun plus(userListFragmentModule: UserListFragmentModule): UserListFragmentComponent
    fun plus(detailsFragmentModule: DetailsFragmentModule): DetailFragmentComponent
}