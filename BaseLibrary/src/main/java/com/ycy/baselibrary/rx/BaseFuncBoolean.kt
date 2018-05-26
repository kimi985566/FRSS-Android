package com.kotlin.base.rx

import com.ycy.baselibrary.common.ResultCode
import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.baselibrary.data.protocol.BaseRespDataClass
import com.ycy.baselibrary.rx.BaseException
import rx.Observable
import rx.functions.Func1

/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        //TODO
        var a=(t.data as BaseRespDataClass)
        if (a.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(a.status, a.message))
        }

        return Observable.just(true)
    }
}