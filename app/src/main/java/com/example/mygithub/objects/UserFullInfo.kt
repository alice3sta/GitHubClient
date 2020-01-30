package com.example.mygithub.objects

import com.google.gson.annotations.SerializedName

class UserFullInfo(
    @SerializedName("login") val userLogin: String,
    @SerializedName("id") val userId: Long,
    @SerializedName("avatar_url") val userAvatar: String,
    @SerializedName("name") val userName: String?,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("location") val location: String?,
    @SerializedName("created_at") val createdAt: String = ""
)