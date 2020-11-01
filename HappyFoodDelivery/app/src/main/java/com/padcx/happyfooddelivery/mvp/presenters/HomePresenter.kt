package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import com.padcx.happyfooddelivery.mvp.views.HomeView

interface HomePresenter : BasePresenter<HomeView>,RestaurantItemDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
}