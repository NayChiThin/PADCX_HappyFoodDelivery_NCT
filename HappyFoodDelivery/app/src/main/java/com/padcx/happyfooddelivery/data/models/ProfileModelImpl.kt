package com.padcx.happyfooddelivery.data.models

import android.graphics.Bitmap
import com.padcx.happyfooddelivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happyfooddelivery.network.FirebaseApi

object ProfileModelImpl:ProfileModel {
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun uploadProfileImage(image: Bitmap) {
        mFirebaseApi.uploadProfileImage(image)
    }
}