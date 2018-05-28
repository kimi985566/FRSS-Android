package com.ycy.user.presenter.view

import com.ycy.baselibrary.presenter.view.BaseView
import com.ycy.user.data.protocol.UserInfo

interface LoginView : BaseView {

    fun onLoginResult(result: UserInfo)

}