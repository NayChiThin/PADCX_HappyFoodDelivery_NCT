package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.MainModel
import com.padcx.happyfooddelivery.data.models.impls.MainModelImpl
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.MainPresenter
import com.padcx.happyfooddelivery.mvp.views.MainView

class MainPresenterImpl:MainPresenter ,AbstractBasePresenter<MainView>(){

    private val mMainModel : MainModel =
        MainModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mView.setLayoutType(mMainModel.getLayoutType())
    }
}