package com.ycy.user.injection.module

import com.ycy.user.service.UserService
import com.ycy.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @Module
 *
 * 第三方库无法修改，不能在其构造函数添加@Inject
 * 接口不能实例化，只能通过实现类实例化
 * Module实际就是一个简单工厂，创建类实例的方法
 * Component通过modules属性加入多个Module
 *
 * */

@Module
class UserModule {

    /**
     * @Provides
     *
     * 在Module中，使用@Provides标注创建实例的方法
     *
     * 实例化流程：
     * 1. Component搜索@Inject注解的属性
     * 2. Component查找Module中以@Provides注解的对应方法，创建实例
     * */

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}