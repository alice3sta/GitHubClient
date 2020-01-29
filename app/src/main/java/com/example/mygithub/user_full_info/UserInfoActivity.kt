package com.example.mygithub.user_full_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mygithub.R
import com.example.mygithub.objects.UserFullInfo
import com.example.mygithub.objects.UserInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity(), UserFullInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val presenter = UserFullInfoPresenter(this, UserFullInfoInteractorImpl(UserFullInfoRepoImpl()))

        val userList = intent.getSerializableExtra("User") as UserInfo
        user_id.text = getString(R.string.user_id_text, userList.userId)
        user_login.setText(userList.userLogin)
        Picasso.get().load(userList.userAvatar).into(user_avatar)

        presenter.getFullUserInfo(userList.userLogin)
    }

    override fun showFullUserInfo(userFullInfo: UserFullInfo) {
        user_name.text = getString(R.string.name_text, userFullInfo.userName)
        user_location.text = getString(R.string.location_text, userFullInfo.location)
        user_public_repos.text = getString(R.string.public_repos_text, userFullInfo.publicRepos)
    }
}
