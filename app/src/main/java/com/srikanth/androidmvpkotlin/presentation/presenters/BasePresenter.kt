package com.srikanth.androidmvpkotlin.presentation.presenters

/**
 * Created by Srikanth Roopa on 12/29/2017.
 */
abstract class BasePresenter<T> {
    var view: T? = null
        private set

    fun attachView(view: T){
        this.view = view
    }

    fun detachView(){
        this.view= view
    }

    val isViewAttached: Boolean
        get() = view != null
}