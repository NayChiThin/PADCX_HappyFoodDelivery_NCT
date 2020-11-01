package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.MainView

interface MainPresenter:BasePresenter<MainView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}