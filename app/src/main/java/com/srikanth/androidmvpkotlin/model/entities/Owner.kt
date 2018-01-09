package com.srikanth.androidmvpkotlin.model.entities

import com.google.gson.annotations.SerializedName


data class Owner(@SerializedName("user_id") var userId: Long) {
    constructor() : this(-1)

}