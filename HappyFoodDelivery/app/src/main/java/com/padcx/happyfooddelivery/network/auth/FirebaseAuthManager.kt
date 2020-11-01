package com.padcx.happyfooddelivery.network.auth

import android.net.Uri
import androidx.core.net.toUri
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManager : AuthManager {

    private val mFirebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete) {
                onSuccess()
            }else {
                onFailure(it.exception?.message?:"Please check internet connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete) {
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(userName).build()
                )
                onSuccess()
            }else {
                onFailure(it.exception?.message?:"Please check internet connection")
            }
        }
    }

    override fun getUserEmail(): String {
        return mFirebaseAuth.currentUser?.email?:""
    }

    override fun updatePhotoUrl(imageUrl: Uri) {
        mFirebaseAuth.currentUser?.updateProfile(
            UserProfileChangeRequest.Builder().setPhotoUri(imageUrl).build()
        )
    }

    override fun getPhotoUrl(): Uri {
        return mFirebaseAuth.currentUser?.photoUrl?:"".toUri()
    }
}