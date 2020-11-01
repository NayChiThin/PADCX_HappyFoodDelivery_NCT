package com.padcx.happyfooddelivery.mvp.presenters

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.mvp.views.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {
    fun onTapCancel()
    fun onTapSave(image:Bitmap?)
    fun onTapPicture()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}