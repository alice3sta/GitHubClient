package com.example.mygithub.user_screen

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserScreenPresenter(private val view: UserScreenView, private val interactor: UserScreenInteractor) {

    private val compositeDisposable = CompositeDisposable()

    fun onSearchQueryChanged() {
        val searchQuery = view.getSearchQuery()
        val disposable = interactor.getUsers(searchQuery)
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

        compositeDisposable.add(disposable)
    }

    fun onDataStartedToChange() {
        view.hideUserList()
        view.showProgress()
    }

    fun clear() {
        compositeDisposable.dispose()
    }
}