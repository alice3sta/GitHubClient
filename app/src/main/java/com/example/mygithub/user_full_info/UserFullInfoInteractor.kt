package com.example.mygithub.user_full_info

import com.example.mygithub.objects.UserFullInfo
import io.reactivex.Observable

interface UserFullInfoInteractor {
    fun getFullUserInfo(name: String): Observable<UserFullInfo>
}