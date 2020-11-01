package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.fragments.HomeFragment
import com.padcx.happyfooddelivery.fragments.PopularHomeFragment
import com.padcx.happyfooddelivery.mvp.presenters.MainPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.MainPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() ,MainView{

    private lateinit var mMainPresenter : MainPresenter
    private var layoutType : Int = 0

    companion object {
        fun newIntent(context:Context):Intent {
            return Intent(context,MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()
        mMainPresenter.onUiReady(this)

        bottomNavigation.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.action_home -> {
                        when(layoutType) {
                            0-> {
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.flBottomNavigationContainer,HomeFragment())
                                    .commit()
                                return true
                            }
                            1-> {
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.flBottomNavigationContainer,PopularHomeFragment())
                                    .commit()
                                return true
                            }
                        }
                    }
                    R.id.action_account -> {
                        startActivity(ProfileActivity.newIntent(applicationContext))
                    }
                }
                return false
            }
        })
        if(savedInstanceState == null) {
            bottomNavigation.selectedItemId = R.id.action_home
        }
    }
    private fun setUpPresenter() {
        mMainPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mMainPresenter.initPresenter(this)
    }

    override fun setLayoutType(layoutType:Int) {
        this.layoutType = layoutType
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
}