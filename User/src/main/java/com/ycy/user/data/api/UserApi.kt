package com.ycy.user.data.api

import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.user.data.protocol.LoginReq
import com.ycy.user.data.protocol.RegisterReq
import com.ycy.user.data.protocol.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    /*
      用户注册
    */
    @POST("data/user/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>

    /*
        用户登陆
     */
    @POST("data/user/login")
    fun login(@Body req: LoginReq): Observable<BaseResp<UserInfo>>
}