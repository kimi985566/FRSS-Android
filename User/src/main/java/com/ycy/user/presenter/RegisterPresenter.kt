package com.ycy.user.presenter

import com.ycy.baselibrary.ext.execute
import com.ycy.baselibrary.presenter.BasePresenter
import com.ycy.baselibrary.rx.BaseSubscriber
import com.ycy.user.presenter.view.RegisterView
import com.ycy.user.service.UserService
import javax.inject.Inject

/**
 * Inject和Module维度
 *
 * Module优先级高于Inject构造函数
 * 查找到实例对象，依次查看其参数实例化
 * Module中存在创建实例方法，则停止查找Inject维度，如果没有，查找Inject构造函数
 *
 * */

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