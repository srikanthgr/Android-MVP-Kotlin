package com.srikanth.androidmvpkotlin.di.components

import com.srikanth.androidmvpkotlin.di.modules.DetailsFragmentModule
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(DetailsFragmentModule::class))
interface DetailFragmentComponent {
}