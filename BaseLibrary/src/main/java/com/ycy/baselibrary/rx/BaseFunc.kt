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
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        //TODO
        var a = (t.data as BaseRespDataClass)
        if (a.status != ResultCode.SUCCESS) {
            return Observable.error(BaseException(a.status, a.message))
        }

        return Observable.just(t.data)
    }
}