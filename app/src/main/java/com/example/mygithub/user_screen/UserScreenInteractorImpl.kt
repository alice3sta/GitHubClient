package com.example.mygithub.user_screen

import com.example.mygithub.objects.UserInfo
import io.reactivex.Observable

class UserScreenInteractorImpl(private val repo: UserScreenRepo) : UserScreenInteractor {
    override fun getUsers(userName: String): Observable<List<UserInfo>> {
        return repo.getUsers(userName)
    }
}