package com.srikanth.androidmvpkotlin.utils

import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.srikanth.androidmvpkotlin.App

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}
val Fragment.app: App
    get() = activity.application as App

fun ImageView.loadUrl(url: String) = com.bumptech.glide.Glide.with(context).load(url).into(this)
