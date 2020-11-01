package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.network.FirebaseApi

interface CartModel {
    var mFirebaseApi : FirebaseApi
    fun getCartItems(onSuccess:(List<FoodVO>)->Unit, onFailure: (String) -> Unit)
    fun deleteCartItems()
}