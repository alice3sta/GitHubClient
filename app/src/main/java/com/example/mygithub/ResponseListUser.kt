package com.example.mygithub

import com.google.gson.annotations.SerializedName

class ResponseListUser(@SerializedName("items") val userList: List<UserInfo>)