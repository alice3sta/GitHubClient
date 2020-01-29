package com.example.mygithub.network

import com.example.mygithub.objects.ResponseListUser
import com.example.mygithub.objects.UserFullInfo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
    @GET("/search/users")
    fun getUserInfo(
        @Query("q") userName: String
    ): Observable<ResponseListUser>

    @GET("/users/{username}")
    fun getOneUser(
        @Path("username") userName: String
    ): Observable<UserFullInfo>
}