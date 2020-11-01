package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.auth.AuthManager
import com.padcx.happyfooddelivery.network.auth.FirebaseAuthManager

object LoginModelImpl : LoginModel {
    override var mAuthManager: AuthManager = FirebaseAuthManager


    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email,password,onSuccess,onFailure)
    }
}