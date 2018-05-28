package com.ycy.user.ui.activity

import android.os.Bundle
import android.view.View
import com.ycy.baselibrary.common.AppManager
import com.ycy.baselibrary.ext.enable
import com.ycy.baselibrary.ext.onClick
import com.ycy.baselibrary.ui.activity.BaseMVPActivity
import com.ycy.baselibrary.utils.ColoredSnackbar
import com.ycy.user.R
import com.ycy.user.injection.component.DaggerUserComponent
import com.ycy.user.injection.module.UserModule
import com.ycy.user.presenter.RegisterPresenter
import com.ycy.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var pressTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    /**
     * 初始化视图
     * */
    private fun initView() {
        mRegisterBtn.enable(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isBtnEnable() })

        mRegisterBtn.onClick(this)
    }

    override fun injectComponent() {
        DaggerUserComponent
                .builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)

        mPresenter.mView = this
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mRegisterBtn -> {
                if (mPwdEt.text.toString() != mPwdConfirmEt.text.toString()) {
                    ColoredSnackbar.alert(mRegisterRootView, "密码不一致").show()
                    return@onClick
                }
                mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString())
            }
        }
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast(resources.getString(R.string.pressAgain))
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    /**
     *判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}