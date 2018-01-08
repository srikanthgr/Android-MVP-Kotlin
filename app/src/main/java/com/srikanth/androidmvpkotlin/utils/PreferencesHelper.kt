package com.srikanth.androidmvpkotlin.utils

import android.content.Context
import android.preference.PreferenceManager


class PreferencesHelper(private val context: Context) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun save(key: String, value: Long) {
        val editor = preferences.edit()
        editor.putLong(key, value)
        editor.commit()
    }

    fun getLong(key: String): Long = preferences.getLong(key, 0L)
}