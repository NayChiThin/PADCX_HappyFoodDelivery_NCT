package com.padcx.happyfooddelivery.mvp.views

import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface PopularHomeView :BaseView{
    fun displayPopularRestaurant(restaurantList:List<RestaurantVO>)
    fun displayNewRestaurant(restaurantList: List<RestaurantVO>)
    fun navigateToDetails(restaurant:RestaurantVO)
}