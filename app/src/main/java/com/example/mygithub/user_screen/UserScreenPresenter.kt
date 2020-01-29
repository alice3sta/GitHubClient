package com.example.mygithub.user_screen

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserScreenPresenter(
    val view: UserScreenView,
    val interactor: UserScreenInteractor
) {
    fun onSearchQueryChanged() {
        val searchQuery = view.getSearchQuery()
        interactor.getUsers(searchQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideProgress()
                if (it.isEmpty()) {
                    view.hideUserList()
                   view.showUserNotFound()
                } else {
                    view.showUserList()
                    view.showUsers(it)
                }
            }, {
                view.hideProgress()
                view.showError()
            })
    }

    fun onDataStartedToChange() {
        view.hideUserList()
        view.showProgress()
    }
}