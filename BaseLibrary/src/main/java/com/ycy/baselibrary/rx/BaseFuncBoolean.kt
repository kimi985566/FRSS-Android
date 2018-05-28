package com.kotlin.base.rx

import com.ycy.baselibrary.common.ResultCode
import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.baselibrary.rx.BaseException
import rx.Observable
import rx.functions.Func1

/*
    Boolean类型转换封装
 */
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.errorNo != ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.errorNo, t.errorMsg))
        }

        return Observable.just(true)
    }
}