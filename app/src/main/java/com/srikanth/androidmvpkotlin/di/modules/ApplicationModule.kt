package com.srikanth.androidmvpkotlin.di.modules

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.Gson
import com.srikanth.androidmvpkotlin.model.persistence.AppDatabase
import com.srikanth.androidmvpkotlin.model.repositories.DefaultUserRepository
import com.srikanth.androidmvpkotlin.model.repositories.UserRepository
import com.srikanth.androidmvpkotlin.model.services.UserService
import com.srikanth.androidmvpkotlin.utils.*
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
    fun provideUserRepository(retrofit: Retrofit, database: AppDatabase, connectionHelper: ConnectionHelper,
                              preferencesHelper: PreferencesHelper, calendarWrapper: CalendarWrapper): UserRepository {
        return DefaultUserRepository(retrofit.create(UserService::class.java), database.userDao(), connectionHelper, preferencesHelper, calendarWrapper)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context)
            = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideConnectionHelper(context: Context) = ConnectionHelper(context)

    @Provides
    @Singleton
    fun providePreferenceHelper(context:Context) = PreferencesHelper(context)

    @Provides
    @Singleton
    fun provideCalendarWrapper() = CalendarWrapper()

    @Provides
    @Singleton
    fun provideSchedulerProvider() : SchedulerProvider = AppSchedulerProvider()

}