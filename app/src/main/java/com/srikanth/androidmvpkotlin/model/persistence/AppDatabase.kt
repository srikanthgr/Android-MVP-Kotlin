package com.srikanth.androidmvpkotlin.model.persistence

import android.arch.persistence.room.Database
import com.srikanth.androidmvpkotlin.model.entities.User


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase {
    abstract fun userDao(): UserDao
}