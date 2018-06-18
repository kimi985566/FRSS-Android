package com.ycy.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ycy.baselibrary.ext.enable
import com.ycy.baselibrary.ext.onClick
import com.ycy.baselibrary.ui.activity.BaseMVPActivity
import com.ycy.user.R
import com.ycy.user.data.protocol.UserInfo
import com.ycy.user.injection.component.DaggerUserComponent
import com.ycy.user.injection.module.UserModule
import com.ycy.user.presenter.LoginPresenter
import com.ycy.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginView, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    /**
     * 初始化视图
     * */
    private fun initView() {
        mLoginBtn.enable(mMobileEt, { isBtnEnable() })
        mLoginBtn.enable(mPwdEt, { isBtnEnable() })

        mLoginBtn.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    //登陆回调
    override fun onLoginResult(result: UserInfo) {
        toast(getString(R.string.loginSuccess))
        //UserPrefsUtils.putUserInfo(result)
        finish()
    }

    override fun injectComponent() {
        /**
         * Dagger2采用了apt代码自动生成技术，其注解是停留在编译时，不影响性能
         *
         * Module并不是必需的，但Component是必不可少的；
         * 编译后生成的Component实现类的名称是Dagger+我们所定义的Component接口的名称
         *
         * 注入到当前的Activity之中
         * */
        DaggerUserComponent
                .builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)

        mPresenter.mView = this
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString())
            }
            R.id.mRightTv -> {
                startActivity<RegisterActivity>()
            }
        }
    }

    /**
     *判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
