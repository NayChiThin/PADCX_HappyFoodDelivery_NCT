package com.padcx.happyfooddelivery.mvp.views

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface DetailView:BaseView {
    fun displayDetail(restaurant:RestaurantVO)
    fun displayPopularFood(foodList:List<FoodVO>)
    fun displayFood(foodList: List<FoodVO>)
    fun navigateToHome()
    fun navigateToCart(restaurant: RestaurantVO)
    fun displayToast(message:String)
}