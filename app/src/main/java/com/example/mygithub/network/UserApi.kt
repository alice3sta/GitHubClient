package com.example.mygithub.network

import com.example.mygithub.ResponseListUser
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("/search/users")
    fun getUserInfo(
        @Query("q") userName: String
    ): Observable<ResponseListUser>
}