package com.ycy.user.service.impl

import com.ycy.baselibrary.ext.convertBoolean
import com.ycy.user.data.repository.UserRepository
import com.ycy.user.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    //注册
    override fun register(mobile: String, pwd: String): Observable<Boolean> {
        return repository.register(mobile, pwd).convertBoolean()
    }
}
