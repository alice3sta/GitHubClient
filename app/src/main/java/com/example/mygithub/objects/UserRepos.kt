package com.example.mygithub.objects

import com.google.gson.annotations.SerializedName

class UserRepos(
    @SerializedName("name") val reposName: String,
    @SerializedName("description") val reposDescription: String?,
    @SerializedName("created_at") val reposCreatedAt: String,
    @SerializedName("language") val reposLanguage: String
) {
}