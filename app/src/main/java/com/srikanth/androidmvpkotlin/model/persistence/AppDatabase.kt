package com.srikanth.androidmvpkotlin.model.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.srikanth.androidmvpkotlin.model.entities.User
import com.srikanth.androidmvpkotlin.model.persistence.dao.UserDao


@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}