package com.example.mygithub

import android.widget.ImageView
import com.google.gson.annotations.SerializedName

class UserInfo(
    @SerializedName("login") val userLogin: String, @SerializedName("id") val userId: Long,
    @SerializedName("avatar_url") val userAvatar: ImageView
)
