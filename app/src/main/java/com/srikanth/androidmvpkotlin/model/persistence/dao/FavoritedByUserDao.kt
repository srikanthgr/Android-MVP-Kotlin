package com.srikanth.androidmvpkotlin.model.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.srikanth.androidmvpkotlin.model.entities.FavoritedByUser

@Dao
interface FavoritedByUserDao {
    @Query("SELECT * FROM favoritedByUser WHERE userId = :arg0")
    fun getFavoritesForUser(userId: Long) : FavoritedByUser?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoritedByUser: FavoritedByUser)
}