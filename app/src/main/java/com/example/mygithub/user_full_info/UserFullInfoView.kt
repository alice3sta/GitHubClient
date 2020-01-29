package com.example.mygithub.user_full_info

import com.example.mygithub.objects.UserFullInfo

interface UserFullInfoView {
    fun showFullUserInfo(userFullInfo : UserFullInfo)
    fun showError()
    fun showProgress()
    fun hideProgress()
}