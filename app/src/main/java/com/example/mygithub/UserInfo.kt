package com.example.mygithub

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserInfo(
    @SerializedName("login") val userLogin: String,
    @SerializedName("id") val userId: Long,
    @SerializedName("avatar_url") val userAvatar: String
) : Serializable
