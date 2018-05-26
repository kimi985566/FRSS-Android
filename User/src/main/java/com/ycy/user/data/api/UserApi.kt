package com.ycy.user.data.api

import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.baselibrary.data.protocol.BaseRespDataClass
import com.ycy.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    /*
      用户注册
    */
    @POST("unnamed/user/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<BaseRespDataClass>>
}