package com.example.mygithub

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserScreenPresenter(
    val view: UserScreenView,
    val interactor: UserScreenInteractor
) {
    fun onSearchQueryChanged() {
        val searchQuery = view.getSearchQuery()
        interactor.getUsers(searchQuery)
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showUsers()
            }, {
                view.showError()
            })
    }
}