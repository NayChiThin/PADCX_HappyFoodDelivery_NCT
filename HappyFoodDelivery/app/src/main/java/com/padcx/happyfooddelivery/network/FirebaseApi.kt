package com.padcx.happyfooddelivery.network

import android.graphics.Bitmap
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface FirebaseApi {
    fun getRestaurants(onSuccess:(restaurants:List<RestaurantVO>)->Unit,onFailure:(String)->Unit)
    fun getPopularRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit,onFailure: (String) -> Unit)
    fun getNewRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit,onFailure: (String) -> Unit)
    fun addFoodToCart(food:FoodVO)
    fun getCartItems(onSuccess:(cartItems:List<FoodVO>)->Unit,onFailure: (String) -> Unit)
    fun deleteCartItems()
    fun uploadProfileImage(image:Bitmap)
    fun getFoodList(restaurantName:String,onSuccess:(foodList:List<FoodVO>)->Unit,onFailure: (String) -> Unit)
}