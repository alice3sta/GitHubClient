package com.example.mygithub.user_screen

import com.example.mygithub.network.DataUserApi
import com.example.mygithub.objects.UserInfo
import io.reactivex.Observable


class UserScreenRepoImpl : UserScreenRepo {
    override fun getUsers(userName: String): Observable<List<UserInfo>> {
        return DataUserApi().getApi().getUserInfo(userName).map {
            it.userList
        }
    }
}