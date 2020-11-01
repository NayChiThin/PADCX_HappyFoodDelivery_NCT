package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.network.FirebaseApi

interface DetailModel {
    var mFirebaseApi : FirebaseApi
    fun addFoodToCart(food: FoodVO)
    fun deleteCartItems()
    fun getFoodList(restaurantName:String,onSuccess:(List<FoodVO>)->Unit,onFailure:(String)->Unit)
}