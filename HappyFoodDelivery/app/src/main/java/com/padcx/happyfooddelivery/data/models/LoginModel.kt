package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.auth.AuthManager

interface LoginModel {
    var mAuthManager : AuthManager
    fun login(email:String,password:String,onSuccess:()->Unit,onFailure:(String)->Unit)
}