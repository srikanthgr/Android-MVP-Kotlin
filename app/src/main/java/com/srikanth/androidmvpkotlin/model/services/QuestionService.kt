package com.srikanth.androidmvpkotlin.model.services

import com.srikanth.androidmvpkotlin.model.entities.QuestionList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface QuestionService {
    @GET("/questions/{questionIds}?order=desc&sort=activity&site=stackoverflow")
    fun getQuestionsById(@Path("questionIds") questionId: String) : Call<QuestionList>
}