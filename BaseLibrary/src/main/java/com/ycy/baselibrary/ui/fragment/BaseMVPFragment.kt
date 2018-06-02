package com.ycy.baselibrary.ui.fragment

import android.os.Bundle
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.ycy.baselibrary.common.BaseApplication
import com.ycy.baselibrary.presenter.BasePresenter
import com.ycy.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

abstract class BaseMVPFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()

        injectComponent()

    }

    protected abstract fun injectComponent()

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
        toast(text)
    }

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent
                .builder()
                .appComponent((activity!!.application as BaseApplication).mAppComponent)
                .activityModule(ActivityModule(activity!!))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }
}
