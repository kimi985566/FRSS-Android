package com.ycy.provider.common

import com.ycy.baselibrary.common.BaseConstant
import com.ycy.baselibrary.utils.AppPrefsUtils

fun isLogined(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}