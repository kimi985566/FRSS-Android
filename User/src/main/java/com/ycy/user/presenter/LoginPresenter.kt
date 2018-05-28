package com.ycy.user.presenter

import com.ycy.baselibrary.ext.execute
import com.ycy.baselibrary.presenter.BasePresenter
import com.ycy.baselibrary.rx.BaseSubscriber
import com.ycy.user.data.protocol.UserInfo
import com.ycy.user.presenter.view.LoginView
import com.ycy.user.service.UserService
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    /*
       登录
    */
    fun login(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd).execute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
            }
        }, lifecycleProvider)

    }
}