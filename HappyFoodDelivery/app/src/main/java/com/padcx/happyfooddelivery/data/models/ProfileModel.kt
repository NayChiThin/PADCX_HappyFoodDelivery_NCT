package com.padcx.happyfooddelivery.data.models

import android.graphics.Bitmap
import com.padcx.happyfooddelivery.network.FirebaseApi

interface ProfileModel {
    var mFirebaseApi : FirebaseApi
    fun uploadProfileImage(image:Bitmap)
}