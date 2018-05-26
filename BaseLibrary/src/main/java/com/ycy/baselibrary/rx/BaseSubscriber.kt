package com.ycy.baselibrary.rx

import com.ycy.baselibrary.presenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(private val mBaseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {
        mBaseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        mBaseView.hideLoading()
        if (e is BaseException) {
            mBaseView.onError(e.msg)
        }
    }

}