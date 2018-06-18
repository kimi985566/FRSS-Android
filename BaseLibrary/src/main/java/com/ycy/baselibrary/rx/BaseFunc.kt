package com.kotlin.base.rx

import android.util.Log
import com.ycy.baselibrary.common.ResultCode
import com.ycy.baselibrary.data.protocol.BaseResp
import com.ycy.baselibrary.rx.BaseException
import rx.Observable
import rx.functions.Func1

/*
    Boolean类型转换封装
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.errorNo!= ResultCode.SUCCESS) {
            return Observable.error(BaseException(t.errorNo, t.errorMsg))
        }

        return Observable.just(t.data)
    }
}