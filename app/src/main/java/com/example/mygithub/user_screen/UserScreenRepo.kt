package com.example.mygithub.user_screen

import com.example.mygithub.objects.UserInfo
import io.reactivex.Observable

interface UserScreenRepo {
    fun getUsers(userName: String): Observable<List<UserInfo>>
}