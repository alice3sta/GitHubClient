package com.example.mygithub.objects

import com.google.gson.annotations.SerializedName

class ResponseListUser(@SerializedName("items") val userList: List<UserInfo>)