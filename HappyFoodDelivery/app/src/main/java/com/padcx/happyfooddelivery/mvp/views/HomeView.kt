package com.padcx.happyfooddelivery.mvp.views

import com.padcx.happyfooddelivery.data.vos.FoodTypeVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface HomeView : BaseView {
    fun displayFoodTypeList(foodTypeList:List<FoodTypeVO>)
    fun displayRestaurantList(restaurantList:List<RestaurantVO>)
    fun navigateToDetails(restaurant:RestaurantVO)
}