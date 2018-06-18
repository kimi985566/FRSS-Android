package com.ycy.baselibrary.cache

import com.ycy.baselibrary.data.protocol.CacheBean
import com.ycy.baselibrary.utils.FileUtils
import rx.Observable

class DiskCache : ICache {

    companion object {
        private val CACHE_PATH: String = FileUtils.cacheDir
    }

    override fun <T : CacheBean> get(key: String, cls: Class<T>): Observable<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : CacheBean> put(key: String, t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}