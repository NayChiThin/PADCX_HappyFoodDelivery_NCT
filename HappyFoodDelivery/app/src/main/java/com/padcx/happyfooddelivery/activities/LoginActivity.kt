package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.mvp.presenters.LoginPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(),LoginView {

    companion object {
        fun newIntent(context: Context):Intent {
            return Intent(context,LoginActivity::class.java)
        }
    }

    private lateinit var mLoginPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpPresenter()
        setUpListener()
        mLoginPresenter.onUiReady(this)
    }
    private fun setUpListener() {
        btnLogin.setOnClickListener {
            mLoginPresenter.onTapLogin(etEmail.text.toString(),etPassword.text.toString())
        }
        ivBack.setOnClickListener {
            mLoginPresenter.onTapBack()
        }
        tvSignUp.setOnClickListener {
            mLoginPresenter.onTapSignUp()
        }
    }
    private fun setUpPresenter() {
        mLoginPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mLoginPresenter.initPresenter(this)
    }

    override fun navigateToStart() {
        finish()
    }

    override fun navigateToHome() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToRegister() {
        startActivity(RegisterActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
}