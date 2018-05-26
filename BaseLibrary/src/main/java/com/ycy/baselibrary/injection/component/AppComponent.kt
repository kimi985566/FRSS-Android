package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @Singleton
 *
 * Scope的一种默认实现
 * 但是其并没有单例的能力
 *
 * */

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context(): Context
}