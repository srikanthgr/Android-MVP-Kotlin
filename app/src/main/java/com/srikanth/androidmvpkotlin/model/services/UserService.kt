package com.srikanth.androidmvpkotlin.model.services

import com.srikanth.androidmvpkotlin.model.entities.UserListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UserService {
    @GET("/users?order=desc&sort=reputation&site=stackoverflow")
    fun getUsers(@Query("page") page: Int = 1) : Call<UserListModel>
}