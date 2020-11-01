package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happyfooddelivery.network.FirebaseApi

object CartModelImpl : CartModel{
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun getCartItems(onSuccess: (List<FoodVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCartItems(onSuccess, onFailure)
    }
    override fun deleteCartItems() {
        mFirebaseApi.deleteCartItems()
    }
}