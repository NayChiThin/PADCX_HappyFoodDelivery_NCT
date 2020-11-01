package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import com.padcx.happyfooddelivery.mvp.views.PopularHomeView

interface PopularHomePresenter:BasePresenter<PopularHomeView>,RestaurantItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}