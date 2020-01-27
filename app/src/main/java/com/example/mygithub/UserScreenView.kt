package com.example.mygithub

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

