package com.padcx.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.delegates.FoodItemDelegate
import com.padcx.happyfooddelivery.mvp.views.DetailView

interface DetailPresenter:BasePresenter<DetailView>,FoodItemDelegate {
    fun onTapBack()
    fun onTapCart(restaurant: RestaurantVO)
    fun onDestroyCart()
    fun onUiReady(lifecycleOwner: LifecycleOwner,restaurant: RestaurantVO)
}