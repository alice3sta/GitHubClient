package com.example.mygithub

import io.reactivex.Observable

interface UserScreenInteractor {
    fun getUsers(userName: String): Observable<List<UserInfo>>
}