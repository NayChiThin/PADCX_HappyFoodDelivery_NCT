package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.IntroductionView

interface IntroductionPresenter:BasePresenter<IntroductionView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onTapLogin()
    fun onTapCreateAccount()
    fun onTapGetStarted()
}