package com.kotlin.base.injection.module

import android.content.Context
import com.ycy.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return this.context
    }

}