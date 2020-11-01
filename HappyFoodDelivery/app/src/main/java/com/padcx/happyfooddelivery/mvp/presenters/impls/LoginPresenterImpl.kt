package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.LoginModel
import com.padcx.happyfooddelivery.data.models.impls.LoginModelImpl
import com.padcx.happyfooddelivery.data.models.MainModel
import com.padcx.happyfooddelivery.data.models.impls.MainModelImpl
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.LoginPresenter
import com.padcx.happyfooddelivery.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter,AbstractBasePresenter<LoginView>() {

    private val mLoginModel : LoginModel =
        LoginModelImpl
    private val mMainModel : MainModel =
        MainModelImpl

    override fun onTapLogin(email: String, password: String) {
        mLoginModel.login(email,password,
            onSuccess = {
            mView.navigateToHome()
        },
        onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapBack() {
        mView.navigateToStart()
    }

    override fun onTapSignUp() {
        mView.navigateToRegister()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mMainModel.setUpRemoteConfigWithDefaultValues()
        mMainModel.fetchRemoteConfigs()
    }

}