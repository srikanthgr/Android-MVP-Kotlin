package com.srikanth.androidmvpkotlin.model.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.srikanth.androidmvpkotlin.model.entities.Answer
import com.srikanth.androidmvpkotlin.model.entities.FavoritedByUser
import com.srikanth.androidmvpkotlin.model.entities.Question
import com.srikanth.androidmvpkotlin.model.entities.User
import com.srikanth.androidmvpkotlin.model.persistence.dao.AnswerDao
import com.srikanth.androidmvpkotlin.model.persistence.dao.FavoritedByUserDao
import com.srikanth.androidmvpkotlin.model.persistence.dao.QuestionDao
import com.srikanth.androidmvpkotlin.model.persistence.dao.UserDao
import com.srikanth.androidmvpkotlin.model.persistence.typeconverters.FavoritedByUserConverter


@Database(entities = arrayOf(User::class, Question::class, Answer::class, FavoritedByUser::class), version = 1)
@TypeConverters(FavoritedByUserConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun questionDao() : QuestionDao
    abstract fun answerDao() : AnswerDao
    abstract fun favoritedByUserDao() : FavoritedByUserDao
}