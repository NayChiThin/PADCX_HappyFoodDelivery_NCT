package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.RegisterView

interface RegisterPresenter :BasePresenter<RegisterView>{
    fun onTapRegister(email:String,password:String,userName:String,phone:String)
    fun onTapBack()
    fun onTapLogin()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}