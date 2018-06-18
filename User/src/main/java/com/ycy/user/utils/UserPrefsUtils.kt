package com.ycy.user.utils

import com.ycy.baselibrary.common.BaseConstant
import com.ycy.baselibrary.utils.AppPrefsUtils
import com.ycy.provider.common.ProviderConstant
import com.ycy.user.data.protocol.UserInfo

object UserPrefsUtils {
    /*
      退出登录时，传入null,清空存储
   */
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
    }
}