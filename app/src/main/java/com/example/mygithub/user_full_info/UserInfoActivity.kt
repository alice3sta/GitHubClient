package com.example.mygithub.user_full_info

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mygithub.R
import com.example.mygithub.objects.UserFullInfo
import com.example.mygithub.objects.UserInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity(), UserFullInfoView {

    val presenter = UserFullInfoPresenter(this, UserFullInfoInteractorImpl(UserFullInfoRepoImpl()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val userList = intent.getSerializableExtra("User") as UserInfo
        user_id.text = getString(R.string.user_id_text, userList.userId)
        user_login.text = userList.userLogin
        Picasso.get().load(userList.userAvatar).into(user_avatar)

        presenter.getFullUserInfo(userList.userLogin)
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun showFullUserInfo(userFullInfo: UserFullInfo) {
        user_name.text = getString(R.string.name_text, userFullInfo.userName ?: getString(R.string.emptyname))
        user_location.text = getString(R.string.location_text, userFullInfo.location ?: getString(R.string.emptyname))
        user_public_repos.text = getString(R.string.public_repos_text, userFullInfo.publicRepos)
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    override fun showError() {
        error_search.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }
}
