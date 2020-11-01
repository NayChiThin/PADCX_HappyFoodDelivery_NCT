package com.padcx.happyfooddelivery.mvp.presenters

import com.padcx.happyfooddelivery.mvp.views.GetStartedView

interface GetStartedPresenter : BasePresenter<GetStartedView> {
    fun onTapGetStarted()
    fun onUiReady()
    fun onFirstLaunch()
}