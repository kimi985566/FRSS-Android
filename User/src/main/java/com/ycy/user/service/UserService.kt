package com.ycy.user.service

import rx.Observable

interface UserService {
    //用户注册
    fun register(mobile: String, pwd: String): Observable<Boolean>

}