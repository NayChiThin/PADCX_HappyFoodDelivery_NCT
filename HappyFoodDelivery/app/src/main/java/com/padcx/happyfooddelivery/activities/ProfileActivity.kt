package com.padcx.happyfooddelivery.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.ProfilePresenterImpl
import com.padcx.happyfooddelivery.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.IOException

class ProfileActivity : BaseActivity(),ProfileView {

    private lateinit var mProfilePresenter : ProfilePresenter
    private var bitmap : Bitmap? = null

    companion object {
        const val PICK_IMAGE_REQUEST = 1111
        fun newIntent(context: Context):Intent {
            return Intent(context,ProfileActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setUpPresenter()
        setUpListener()
        mProfilePresenter.onUiReady(this)
    }

    private fun setUpListener() {
        tvCancel.setOnClickListener {
            mProfilePresenter.onTapCancel()
        }
        tvSave.setOnClickListener {
            mProfilePresenter.onTapSave(bitmap)
        }
        ivUpload.setOnClickListener {
            mProfilePresenter.onTapPicture()
        }
    }

    private fun setUpPresenter() {
        mProfilePresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mProfilePresenter.initPresenter(this)
    }

    override fun navigateToMain() {
        finish()
    }

    override fun displayProfileDetails(email:String) {
        etEmail.setText(email)
    }

    override fun openGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Select Chooser"), PICK_IMAGE_REQUEST)
    }

    override fun displayProfileUrl(imageUrl:Uri) {
        Glide.with(this)
            .load(imageUrl)
            .into(ivProfile)
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== PICK_IMAGE_REQUEST && resultCode== Activity.RESULT_OK) {
            if(data==null || data.data==null) {
                return
            }
            val filePath = data.data
            try {
                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source : ImageDecoder.Source = ImageDecoder.createSource(this.contentResolver,filePath)
                        bitmap = ImageDecoder.decodeBitmap(source)
                        Glide.with(this)
                            .load(it)
                            .into(ivProfile)
                    }
                    else {
                        bitmap = MediaStore.Images.Media.getBitmap(applicationContext.contentResolver,filePath)
                        Glide.with(this)
                            .load(it)
                            .into(ivProfile)
                    }
                }
            }catch (e : IOException) {
                e.printStackTrace()
            }
        }
    }
}