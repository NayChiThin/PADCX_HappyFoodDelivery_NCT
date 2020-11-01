package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.RegisterModel
import com.padcx.happyfooddelivery.data.models.impls.RegisterModelImpl
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.RegisterPresenter
import com.padcx.happyfooddelivery.mvp.views.RegisterView

class RegisterPresenterImpl:RegisterPresenter,AbstractBasePresenter<RegisterView>() {

    private val mRegisterModel : RegisterModel =
        RegisterModelImpl

    override fun onTapRegister(email: String, password: String, userName: String, phone: String) {
        mRegisterModel.register(email,password,userName,phone,
        onSuccess = {
            mView.navigateToLogin()
        },
        onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapBack() {
        mView.navigateToPreviousScreen()
    }

    override fun onTapLogin() {
        mView.navigateToLogin()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}