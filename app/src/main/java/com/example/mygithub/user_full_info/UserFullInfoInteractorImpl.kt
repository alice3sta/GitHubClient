package com.example.mygithub.user_full_info

import com.example.mygithub.objects.UserFullInfo
import io.reactivex.Observable

class UserFullInfoInteractorImpl(val repo: UserFullInfoRepo) : UserFullInfoInteractor {

    override fun getFullUserInfo(name: String): Observable<UserFullInfo> {
       return repo.getFullUserInfo(name)
    }
}