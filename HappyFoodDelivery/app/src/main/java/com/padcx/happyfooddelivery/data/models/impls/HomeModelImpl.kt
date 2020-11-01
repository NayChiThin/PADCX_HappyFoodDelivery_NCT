package com.padcx.happyfooddelivery.data.models.impls

import com.padcx.happyfooddelivery.data.models.HomeModel
import com.padcx.happyfooddelivery.data.vos.FoodTypeVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happyfooddelivery.network.FirebaseApi

object HomeModelImpl : HomeModel {
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun getRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getRestaurants(onSuccess,onFailure)
    }

    override fun getPopularRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPopularRestaurants(onSuccess, onFailure)
    }

    override fun getNewRestaurants(
        onSuccess: (List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getNewRestaurants(onSuccess,onFailure)
    }

    override fun getFoodTypes(onSuccess: (List<FoodTypeVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getFoodType(onSuccess, onFailure)
    }
/*
    override fun addFoodToCart(food: FoodVO) {
        mFirebaseApi.addFoodToCart(food)
    }

    override fun getCartItems(onSuccess: (List<FoodVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCartItems(onSuccess, onFailure)
    }

    override fun deleteCartItems() {
        mFirebaseApi.deleteCartItems()
    }*/
}