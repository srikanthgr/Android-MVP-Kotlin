package com.srikanth.androidmvpkotlin

import android.app.Application
import com.srikanth.androidmvpkotlin.di.components.ApplicationComponent
import com.srikanth.androidmvpkotlin.di.components.DaggerApplicationComponent
import com.srikanth.androidmvpkotlin.di.modules.ApplicationModule


class App: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent(){
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
}