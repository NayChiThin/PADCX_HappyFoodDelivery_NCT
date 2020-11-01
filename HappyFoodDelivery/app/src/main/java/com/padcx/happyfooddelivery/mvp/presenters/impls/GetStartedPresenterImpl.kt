package com.padcx.happyfooddelivery.mvp.presenters.impls

import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.GetStartedPresenter
import com.padcx.happyfooddelivery.mvp.views.GetStartedView

class GetStartedPresenterImpl:GetStartedPresenter,AbstractBasePresenter<GetStartedView>() {
    override fun onTapGetStarted() {
        mView.navigateToLogin()
    }

    override fun onUiReady() {
    }

    override fun onFirstLaunch() {
        mView.navigateToIntro()
    }
}