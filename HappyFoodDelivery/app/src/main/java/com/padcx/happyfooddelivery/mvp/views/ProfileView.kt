package com.padcx.happyfooddelivery.mvp.views

import android.graphics.Bitmap
import android.net.Uri

interface ProfileView:BaseView {
    fun navigateToMain()
    fun displayProfileDetails(email:String)
    fun openGallery()
    fun displayProfileUrl(imageUrl:Uri)
}