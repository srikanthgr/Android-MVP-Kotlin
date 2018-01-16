package com.srikanth.androidmvpkotlin.model.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.srikanth.androidmvpkotlin.model.entities.Answer

@Dao
interface AnswerDao {
    @Query("SELECT * FROM answer WHERE userId = :arg0 ORDER BY score DESC LIMIT 3")
    fun getAnswersByUser(userId: Long) : List<Answer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(answers: List<Answer>)

}