package com.example.mygithub.user_full_info

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserFullInfoPresenter(val view: UserFullInfoView, val interactor: UserFullInfoInteractor) {
    fun getFullUserInfo(name: String) {
        interactor.getFullUserInfo(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showFullUserInfo(it)
            }, {

            })
    }
}