package com.srikanth.androidmvpkotlin.model.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.srikanth.androidmvpkotlin.model.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY reputation DESC LIMIT (:arg0 - 1) * 30, 30")
    fun getUsers(page: Int): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)
}