package com.padcx.happyfooddelivery.mvp.views

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface CartView : BaseView {
    fun displayRestaurant(restaurant: RestaurantVO)
    fun navigateToDetail()
    fun displayCartItemList(itemList:List<FoodVO>)
    fun displaySubtotal(totalPrice:Int)
}