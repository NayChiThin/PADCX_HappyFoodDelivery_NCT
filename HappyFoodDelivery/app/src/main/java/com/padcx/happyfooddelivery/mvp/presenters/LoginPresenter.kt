package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email:String,password:String)
    fun onTapBack()
    fun onTapSignUp()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}