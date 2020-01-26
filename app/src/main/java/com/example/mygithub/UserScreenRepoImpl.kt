package com.example.mygithub

import com.example.mygithub.network.DataUserApi
import io.reactivex.Observable


class UserScreenRepoImpl : UserScreenRepo {
    override fun getUsers(userName: String): Observable<List<UserInfo>> {
        return DataUserApi().getApi().getUserInfo(userName).map {
            it.userList
        }
    }
}