package com.example.mygithub.user_screen

import com.example.mygithub.objects.UserInfo

interface UserScreenView {
    fun getSearchQuery(): String
    fun showUsers(listUser: List<UserInfo>)
    fun showError()
    fun hideProgress()
    fun showProgress()
    fun hideUserList()
    fun showUserList()
    fun showUserNotFound()
}

