package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.auth.AuthManager

interface RegisterModel {
    var mAuthManager : AuthManager
    fun register(email:String,password:String,userName:String,phone:String,onSuccess:()->Unit,onFailure:(String)->Unit)
}