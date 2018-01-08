package com.srikanth.androidmvpkotlin.di.modules

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {
    private val BASE_URL = "https://api.stackexchange.com/2.2/"
    private val DATABASE_NAME = "database-name"

    @Provides
    @Singleton
    fun provideAppContext(): Context = application

    @Provides
    @Singleton
    fun provideRetroFit(): Retrofit = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(Gson())).baseUrl(BASE_URL).build()

    @Provides
    @Singleton
    fun provideUserRepository() {}
}