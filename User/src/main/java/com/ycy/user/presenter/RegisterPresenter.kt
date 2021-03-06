package com.ycy.user.presenter

import com.ycy.baselibrary.ext.execute
import com.ycy.baselibrary.presenter.BasePresenter
import com.ycy.baselibrary.rx.BaseSubscriber
import com.ycy.user.presenter.view.RegisterView
import com.ycy.user.service.UserService
import javax.inject.Inject

class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()

        userService.register(mobile, pwd).execute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                if (t)
                    mView.onRegisterResult("注册成功")
            }
        }, lifecycleProvider)
    }
}