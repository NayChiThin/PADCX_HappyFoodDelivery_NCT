package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.views.CartView

interface CartPresenter : BasePresenter<CartView>{
    fun onTapBack()
    fun onTapAddFood()
    fun onTapCheckOut()
    fun onDataReady(restaurant:RestaurantVO)
    fun onDestroyCartItems()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}