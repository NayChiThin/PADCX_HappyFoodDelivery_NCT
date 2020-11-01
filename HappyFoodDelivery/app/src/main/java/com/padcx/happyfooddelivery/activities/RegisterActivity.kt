package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.mvp.presenters.RegisterPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.RegisterPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterView {

    private lateinit var mRegisterPresenter : RegisterPresenter

    companion object {
        fun newIntent(context: Context):Intent {
            return Intent(context,RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpPresenter()
        setUpListener()
    }
    private fun setUpPresenter() {
        mRegisterPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mRegisterPresenter.initPresenter(this)
    }
    private fun setUpListener() {
        btnSignUp.setOnClickListener {
            mRegisterPresenter.onTapRegister(etEmail.text.toString(),etPassword.text.toString(),etUserName.text.toString(),etPhone.text.toString())
        }
        ivBack.setOnClickListener {
            mRegisterPresenter.onTapBack()
        }
        tvLogin.setOnClickListener {
            mRegisterPresenter.onTapLogin()
        }
    }
    override fun navigateToPreviousScreen() {
        finish()
    }

    override fun navigateToLogin() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
}