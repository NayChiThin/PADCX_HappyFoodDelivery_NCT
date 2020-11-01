package com.padcx.happyfooddelivery.mvp.presenters.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.ProfileModel
import com.padcx.happyfooddelivery.data.models.impls.ProfileModelImpl
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.padcx.happyfooddelivery.mvp.views.ProfileView
import com.padcx.happyfooddelivery.network.auth.AuthManager
import com.padcx.happyfooddelivery.network.auth.FirebaseAuthManager

class ProfilePresenterImpl:ProfilePresenter,AbstractBasePresenter<ProfileView>() {

    private val mProfileModel : ProfileModel =
        ProfileModelImpl
    private val mAuthManager : AuthManager = FirebaseAuthManager

    override fun onTapCancel() {
        mView.navigateToMain()
    }

    override fun onTapSave(image: Bitmap?) {
        image?.let {
            mProfileModel.uploadProfileImage(image)
        }
        mView.navigateToMain()
    }

    override fun onTapPicture() {
        mView.openGallery()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mView.displayProfileDetails(mAuthManager.getUserEmail()?:"")
        mView.displayProfileUrl(mAuthManager.getPhotoUrl())
    }
}