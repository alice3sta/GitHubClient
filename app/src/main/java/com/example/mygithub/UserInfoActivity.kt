package com.example.mygithub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val userList = intent.getSerializableExtra("User") as UserInfo
        user_id.setText(userList.userId.toString())
        user_login.setText(userList.userLogin)
        Picasso.get().load(userList.userAvatar).into(user_avatar)
    }
}
