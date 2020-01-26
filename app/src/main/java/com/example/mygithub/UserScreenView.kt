package com.example.mygithub

interface UserScreenView {
    fun getSearchQuery(): String
    fun showUsers(listUser: List<UserInfo>)
    fun showError()
}

