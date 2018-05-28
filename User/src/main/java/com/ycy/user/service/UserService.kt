package com.ycy.user.service

import com.ycy.user.data.protocol.UserInfo
import rx.Observable

interface UserService {
    //用户注册
    fun register(mobile: String, pwd: String): Observable<Boolean>

    //用户登陆
    fun login(mobile: String, pwd: String): Observable<UserInfo>

}