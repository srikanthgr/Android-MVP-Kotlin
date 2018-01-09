package com.srikanth.androidmvpkotlin.di.modules

import com.srikanth.androidmvpkotlin.domain.GetUsers
import com.srikanth.androidmvpkotlin.model.repositories.UserRepository
import com.srikanth.androidmvpkotlin.presentation.presenters.UserListPresenter
import com.srikanth.androidmvpkotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class UserListFragmentModule {
    @Provides
    fun provideGetUsers(userRepository: UserRepository) = GetUsers(userRepository)

    @Provides
    fun providePresenter(getUsers: GetUsers, schedulerProvider: SchedulerProvider) = UserListPresenter(getUsers, schedulerProvider)
}