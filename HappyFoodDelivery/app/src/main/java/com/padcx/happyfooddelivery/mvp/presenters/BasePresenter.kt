package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.BaseView

interface BasePresenter<V:BaseView> {
    fun initPresenter(view:V)
}