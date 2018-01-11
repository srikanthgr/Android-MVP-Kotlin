package com.srikanth.androidmvpkotlin.model.repositories

import com.srikanth.androidmvpkotlin.model.entities.Answer
import com.srikanth.androidmvpkotlin.model.entities.Question
import io.reactivex.Single


interface DetailsRepository {
    fun getQuestionsByUser(userId: Long, forced: Boolean): Single<List<Question>>
    fun getAnswersByUser(userId: Long, forced: Boolean): Single<List<Answer>>
    fun getFavoritesByUser(userId: Long, forced: Boolean): Single<List<Question>>
    fun getQuestionsById(ids: List<Long>, userId: Long, forced: Boolean): Single<List<Question>>
}