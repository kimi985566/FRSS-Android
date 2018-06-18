package com.ycy.baselibrary.cache

import com.ycy.baselibrary.data.protocol.CacheBean
import rx.Observable

interface ICache {
    /*
    * operator 操作符重载
    * */
    operator fun <T : CacheBean> get(key: String, cls: Class<T>): Observable<T>

    fun <T : CacheBean> put(key: String, t: T)
}