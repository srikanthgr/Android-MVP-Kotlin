package com.srikanth.androidmvpkotlin.di.modules

import com.srikanth.androidmvpkotlin.domain.GetDetails
import com.srikanth.androidmvpkotlin.model.repositories.DetailsRepository
import com.srikanth.androidmvpkotlin.presentation.presenters.DetailPresenter
import com.srikanth.androidmvpkotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class DetailsFragmentModule {
    @Provides
    fun provideGetDetails(detailsRepository: DetailsRepository) = GetDetails(detailsRepository)

    @Provides
    fun providePresenter(getDetails: GetDetails, schedulerProvider: SchedulerProvider) = DetailPresenter(getDetails, schedulerProvider)
}