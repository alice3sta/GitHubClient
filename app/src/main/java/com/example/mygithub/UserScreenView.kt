package com.example.mygithub

interface UserScreenView {
    fun getSearchQuery(): String
    fun showUsers()
    fun showError()
}

