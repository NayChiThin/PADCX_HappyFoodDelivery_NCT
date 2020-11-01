package com.padcx.happyfooddelivery.network.auth

import android.net.Uri

interface AuthManager {
    fun login(email:String,password:String,onSuccess:()->Unit,onFailure:(String)->Unit)
    fun register(email:String,password: String,userName:String,phone:String,onSuccess: () -> Unit,onFailure: (String) -> Unit)
    fun getUserEmail():String
    fun updatePhotoUrl(imageUrl:Uri)
    fun getPhotoUrl():Uri
}