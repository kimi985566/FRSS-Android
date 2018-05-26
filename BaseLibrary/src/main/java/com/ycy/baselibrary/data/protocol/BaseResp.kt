package com.ycy.baselibrary.data.protocol


class BaseResp<out T>(val errorNo: Int?, val errorMsg: String?, val data: T) {
}