package com.srikanth.androidmvpkotlin.model.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class User(@SerializedName("user_id") @PrimaryKey var userId: Long,
                @SerializedName("display_name") @PrimaryKey var displayName: String,
                @SerializedName("reputation") @PrimaryKey var reputation: Long,
                @SerializedName("profile_image") @PrimaryKey var profileImage: String)
