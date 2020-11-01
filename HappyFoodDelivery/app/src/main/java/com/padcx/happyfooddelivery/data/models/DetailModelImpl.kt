package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happyfooddelivery.network.FirebaseApi

object DetailModelImpl : DetailModel {
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun addFoodToCart(food: FoodVO) {
        mFirebaseApi.addFoodToCart(food)
    }
    override fun deleteCartItems() {
        mFirebaseApi.deleteCartItems()
    }

    override fun getFoodList(restaurantName:String,onSuccess: (List<FoodVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getFoodList(restaurantName,onSuccess, onFailure)
    }

}