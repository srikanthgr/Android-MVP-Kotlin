package com.srikanth.androidmvpkotlin.utils

import android.support.v4.app.Fragment
import com.srikanth.androidmvpkotlin.App

val Fragment.app: App
    get() = activity.application as App