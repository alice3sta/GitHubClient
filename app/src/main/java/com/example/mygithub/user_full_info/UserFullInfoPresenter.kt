package com.example.mygithub.user_full_info

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserFullInfoPresenter(val view: UserFullInfoView, val interactor: UserFullInfoInteractor) {

    private val compositeDisposable = CompositeDisposable()

    fun getFullUserInfo(name: String) {
        view.showProgress()
        val disposable = interactor.getFullUserInfo(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideProgress()
                view.showFullUserInfo(it)
            }, {
                view.showError()
            })
        compositeDisposable.add(disposable)
    }

    fun clear() {
        compositeDisposable.dispose()
    }
}