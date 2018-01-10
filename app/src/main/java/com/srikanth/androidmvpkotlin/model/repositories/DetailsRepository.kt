package com.srikanth.androidmvpkotlin.model.repositories

import com.srikanth.androidmvpkotlin.model.entities.Question
import io.reactivex.Single


interface DetailsRepository {
    fun getQuestionsByUser(userId: Long, forced: Boolean):Single<List<Question>>
}