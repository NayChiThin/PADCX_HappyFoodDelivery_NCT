package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.mvp.presenters.GetStartedPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.GetStartedPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.GetStartedView
import com.padcx.happyfooddelivery.utils.PrefManager
import kotlinx.android.synthetic.main.activity_get_start.*

class GetStartActivity : BaseActivity(),GetStartedView {

    companion object {
        fun newIntent(context: Context):Intent {
            return Intent(context,GetStartActivity::class.java)
        }
    }

    private lateinit var mPrefManager : PrefManager
    private lateinit var mGetStartedPresenter : GetStartedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_start)

        setUpPresenter()
        setUpListener()
        mGetStartedPresenter.onUiReady()

        mPrefManager = PrefManager(this)
        Log.d("FIRST",mPrefManager.isFirstTimeLaunch.toString())
        if(mPrefManager.isFirstTimeLaunch) {
            mPrefManager.isFirstTimeLaunch = false
            mGetStartedPresenter.onFirstLaunch()
        }

    }
    private fun setUpListener() {
        btnGetStarted.setOnClickListener {
            mGetStartedPresenter.onTapGetStarted()
        }
    }
    private fun setUpPresenter() {
        mGetStartedPresenter = ViewModelProviders.of(this).get(GetStartedPresenterImpl::class.java)
        mGetStartedPresenter.initPresenter(this)
    }

    override fun navigateToLogin() {
        startActivity(Intent(LoginActivity.newIntent(this)))
        finish()
    }

    override fun navigateToIntro() {
        startActivity(Intent(IntroductionActivity.newIntent(this)))
        finish()
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
}