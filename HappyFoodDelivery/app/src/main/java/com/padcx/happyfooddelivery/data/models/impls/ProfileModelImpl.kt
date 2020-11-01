package com.padcx.happyfooddelivery.data.models.impls

import android.graphics.Bitmap
import com.padcx.happyfooddelivery.data.models.ProfileModel
import com.padcx.happyfooddelivery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.happyfooddelivery.network.FirebaseApi

object ProfileModelImpl: ProfileModel {
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun uploadProfileImage(image: Bitmap) {
        mFirebaseApi.uploadProfileImage(image)
    }
}