package com.example.mygithub.user_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygithub.*
import com.example.mygithub.user_full_info.UserInfoActivity
import com.example.mygithub.objects.UserInfo
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(), UserScreenView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = UserScreenPresenter(this, UserScreenInteractorImpl(UserScreenRepoImpl()))

        RxTextView.afterTextChangeEvents(user_search)
            .skipInitialValue()
            .doOnNext {
                presenter.onDataStartedToChange()
            }
            .debounce(700, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                presenter.onSearchQueryChanged()
            }
    }

    override fun showProgress() {
        image_user_found.visibility = View.VISIBLE
        image_user_found.setImageResource(R.drawable.search)
        text_user_found.visibility = View.VISIBLE
        text_user_found.setText(R.string.user_found_progress)
    }

    override fun hideProgress() {
        image_user_found.visibility = View.GONE
        text_user_found.visibility = View.GONE
    }

    override fun hideUserList() {
        user_list.visibility = View.INVISIBLE
    }

    override fun showUserList() {
        user_list.visibility = View.VISIBLE
    }

    override fun showUsers(listUser: List<UserInfo>) {
        user_list.adapter = UserAdapter(listUser, object : UserAdapter.OnItemClicked {
            override fun onItemClicked(position: Int) {
                val intent = Intent(this@MainActivity, UserInfoActivity::class.java)
                    .putExtra( "User", listUser.get(position))
                startActivity(intent)
            }
        })
        user_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        user_list.setHasFixedSize(true)
    }

    override fun showError() {
        text_user_found.visibility = View.VISIBLE
        text_user_found.setText(R.string.error_search)
        image_user_found.visibility = View.VISIBLE
        image_user_found.setImageResource(R.drawable.skull)
    }

    override fun showUserNotFound() {
        image_user_found.visibility = View.VISIBLE
        image_user_found.setImageResource(R.drawable.face)
        text_user_found.visibility = View.VISIBLE
        text_user_found.setText(R.string.user_not_found)
    }

    override fun getSearchQuery(): String {
        return user_search.text.toString()
    }
}
