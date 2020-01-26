package com.example.mygithub

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            .debounce(700, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                presenter.onSearchQueryChanged()
            }
    }

    override fun showUsers(listUser: List<UserInfo>) {
        user_list.adapter = UserAdapter(listUser)
        user_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        user_list.setHasFixedSize(true)
    }

    override fun showError() {
        Toast.makeText(this, "Ошибка поиска", Toast.LENGTH_LONG).show()
    }

    override fun getSearchQuery(): String {
        return user_search.text.toString()
    }
}
