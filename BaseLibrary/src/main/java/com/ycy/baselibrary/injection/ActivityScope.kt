package com.kotlin.base.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * @Scope
 *
 * Scope主要用于Component的组织方式
 * 管理Component与Module之间的匹配关系
 * 提高可读性
 *
 * */

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope
