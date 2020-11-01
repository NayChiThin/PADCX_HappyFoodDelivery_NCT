package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.auth.AuthManager
import com.padcx.happyfooddelivery.network.auth.FirebaseAuthManager

object RegisterModelImpl : RegisterModel {
    override var mAuthManager: AuthManager = FirebaseAuthManager

    override fun register(
        email: String,
        password: String,
        userName:String,
        phone:String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(email,password,userName,phone,onSuccess, onFailure)
    }
}