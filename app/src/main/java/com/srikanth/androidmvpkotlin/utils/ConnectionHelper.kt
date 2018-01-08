package com.srikanth.androidmvpkotlin.utils

import android.content.Context
import android.net.ConnectivityManager


class ConnectionHelper(private val context: Context) {

    //TODO add permissions for access network info
    fun isOnline(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}