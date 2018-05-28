package com.ycy.user.data.repository

import com.ycy.baselibrary.data.net.RetrofitFactory
import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.user.data.api.UserApi
import com.ycy.user.data.protocol.LoginReq
import com.ycy.user.data.protocol.RegisterReq
import com.ycy.user.data.protocol.UserInfo
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {
    /**
     * 用户注册
     * */
    fun register(mobile: String, pwd: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile, pwd))
    }

    /**
     * 用户登陆
     * */
    fun login(mobile: String, pwd: String): Observable<BaseResp<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, pwd))
    }

}