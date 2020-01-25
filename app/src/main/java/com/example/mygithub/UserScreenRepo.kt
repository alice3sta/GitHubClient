package com.example.mygithub

import io.reactivex.Observable

interface UserScreenRepo {
    fun getUsers(userName: String): Observable<List<UserInfo>>
}