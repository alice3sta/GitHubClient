package com.example.mygithub.user_full_info

import com.example.mygithub.network.DataUserApi
import com.example.mygithub.objects.UserFullInfo
import io.reactivex.Observable

class UserFullInfoRepoImpl : UserFullInfoRepo {
    override fun getFullUserInfo(name: String): Observable<UserFullInfo> {
        return DataUserApi().getApi().getOneUser(name)
    }
}