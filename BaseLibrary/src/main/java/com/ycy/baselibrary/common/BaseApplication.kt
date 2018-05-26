package com.ycy.baselibrary.common

import android.app.Application
import android.content.Context
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

class BaseApplication : Application() {

    lateinit var mAppComponent: AppComponent

    /**
     * Kotlin语言中使用"companion object"修饰静态方法，可以使用类名.方法名的形式调用
     * */
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this
    }

    private fun initAppInjection() {
        mAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}