package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.network.FirebaseApi

interface HomeModel {
    var mFirebaseApi : FirebaseApi
    fun getRestaurants(onSuccess:(List<RestaurantVO>)->Unit,onFailure:(String)->Unit)
    fun getPopularRestaurants(onSuccess: (List<RestaurantVO>) -> Unit,onFailure: (String) -> Unit)
    fun getNewRestaurants(onSuccess: (List<RestaurantVO>) -> Unit,onFailure: (String) -> Unit)
    /*fun addFoodToCart(food:FoodVO)
    fun getCartItems(onSuccess:(List<FoodVO>)->Unit,onFailure: (String) -> Unit)
    fun deleteCartItems()*/
}