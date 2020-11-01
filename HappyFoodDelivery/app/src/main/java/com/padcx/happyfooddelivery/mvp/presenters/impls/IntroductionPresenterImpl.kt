package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.IntroductionPresenter
import com.padcx.happyfooddelivery.mvp.views.IntroductionView

class IntroductionPresenterImpl:IntroductionPresenter,AbstractBasePresenter<IntroductionView>(){
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

    override fun onTapLogin() {
        mView.navigateToLogin()
    }

    override fun onTapCreateAccount() {
        mView.navigateToRegister()
    }

    override fun onTapGetStarted() {
        mView.navigateToGetStarted()
    }
}