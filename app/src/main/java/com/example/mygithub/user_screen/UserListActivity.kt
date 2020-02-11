package com.example.mygithub.user_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygithub.R
import com.example.mygithub.network.DataUserApi
import com.example.mygithub.objects.UserInfo
import com.example.mygithub.user_full_info.UserInfoActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class UserListActivity : AppCompatActivity(), UserScreenView {

    lateinit var presenter: UserScreenPresenter
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = UserScreenPresenter(this, UserScreenInteractorImpl(UserScreenRepoImpl(DataUserApi())))

        val disposable = RxTextView.afterTextChangeEvents(user_search)
            .skipInitialValue()
            .doOnNext {
                presenter.onDataStartedToChange()
            }
            .debounce(700, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                presenter.onSearchQueryChanged()
            }

        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        presenter.clear()
        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun showProgress() {
        image_user_found.visibility = View.VISIBLE
        image_user_found.setImageResource(R.drawable.searchman)
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
                val intent = Intent(this@UserListActivity, UserInfoActivity::class.java).putExtra("User", listUser.get(position))
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
