package com.example.mygithub

import io.reactivex.Observable

class UserScreenInteractorImpl(val repo: UserScreenRepo) : UserScreenInteractor {
    override fun getUsers(userName: String): Observable<List<UserInfo>> {
        return repo.getUsers(userName)
    }
}