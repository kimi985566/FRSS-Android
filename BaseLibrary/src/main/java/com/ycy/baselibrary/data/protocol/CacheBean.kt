package com.ycy.baselibrary.data.protocol

import com.google.gson.Gson

abstract class CacheBean {

    companion object {
        //创建文件时间
        private val mCreateTime: Long = System.currentTimeMillis()
        //默认有效期限是1小时： 60 * 60 * 1000
        private const val EXPIRE_LIMIT = (60 * 60 * 1000).toLong()
    }

    //是否过期
    val isExpire: Boolean
        get() = System.currentTimeMillis() - mCreateTime > EXPIRE_LIMIT

    //重写toString()方法
    //即可对数据进行序列化保存，从缓存取数据时又可直接将其取出然后用Gson转成对象即可。
    override fun toString(): String {
        return Gson().toJson(this)
    }
}