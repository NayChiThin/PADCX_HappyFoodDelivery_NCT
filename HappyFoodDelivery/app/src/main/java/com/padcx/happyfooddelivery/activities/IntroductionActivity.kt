package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.mvp.presenters.IntroductionPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.IntroductionPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.IntroductionView
import com.padcx.happyfooddelivery.utils.MyViewPagerAdapter
import com.padcx.happyfooddelivery.utils.PrefManager
import kotlinx.android.synthetic.main.activity_introduction.*


class IntroductionActivity : BaseActivity(),IntroductionView {

    companion object {
        fun newIntent(context: Context):Intent {
            return Intent(context,IntroductionActivity::class.java)
        }
    }

    private lateinit var mIntroductionPresenter : IntroductionPresenter
    private lateinit var prefManager : PrefManager
    private lateinit var dots : Array<TextView>
    private lateinit var layouts : Array<Int>
    private lateinit var myViewPagerAdapter : MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        setUpPresenter()
        setUpListener()
        mIntroductionPresenter.onUiReady(this)

        // check first time launch
        prefManager = PrefManager(this)
        Log.d("FIRST","first "+prefManager.isFirstTimeLaunch.toString())
        if(!prefManager.isFirstTimeLaunch) {
            mIntroductionPresenter.onTapGetStarted()
        }

        layouts = arrayOf(
            R.layout.introduction_slide1,
            R.layout.introduction_slide2,
            R.layout.introduction_slide3
        )


        // bottom dots
        addBottomDots(0)

        myViewPagerAdapter = MyViewPagerAdapter(this,layouts)
        viewPager.adapter = myViewPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }

        })

    }
    private fun setUpListener() {
        btnCreateAccount.setOnClickListener {
            prefManager.isFirstTimeLaunch = false
            mIntroductionPresenter.onTapCreateAccount()
        }
        btnContinueWithFB.setOnClickListener {
            prefManager.isFirstTimeLaunch = false
            mIntroductionPresenter.onTapGetStarted()
        }
        tvLogin.setOnClickListener {
            prefManager.isFirstTimeLaunch = false
            mIntroductionPresenter.onTapLogin()
        }
    }
    private fun setUpPresenter() {
        mIntroductionPresenter = ViewModelProviders.of(this).get(IntroductionPresenterImpl::class.java)
        mIntroductionPresenter.initPresenter(this)
    }
    private fun addBottomDots(currentPage:Int) {
        dots = arrayOf(TextView(this), TextView(this), TextView(this))

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        layoutDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i].text = Html.fromHtml("&#9866;")
            dots[i].textSize = 35F
            dots[i].setTextColor(colorsInactive[currentPage])
            layoutDots.addView(dots[i])
        }
        if(dots.isNotEmpty()) {
            dots[currentPage].setTextColor(colorsActive[currentPage])
        }
    }

    override fun navigateToLogin() {
        startActivity(LoginActivity.newIntent(this))
        finish()
    }

    override fun navigateToRegister() {
        startActivity(RegisterActivity.newIntent(this))
        finish()
    }

    override fun navigateToGetStarted() {
        startActivity(GetStartActivity.newIntent(this))
        finish()
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }

}