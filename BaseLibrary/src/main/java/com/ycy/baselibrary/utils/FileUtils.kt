package com.ycy.baselibrary.utils

import com.ycy.baselibrary.common.BaseApplication

object FileUtils {

    val cacheDir: String
        get() = BaseApplication.context.cacheDir.path
}
