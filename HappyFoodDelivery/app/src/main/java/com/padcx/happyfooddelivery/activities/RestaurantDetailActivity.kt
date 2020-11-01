package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.adapters.FoodListAdapter
import com.padcx.happyfooddelivery.adapters.PopularFoodAdapter
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.DetailPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.DetailPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.DetailView
import com.padcx.happyfooddelivery.utils.RESTAURANT_EXTRA
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import java.io.Serializable

class RestaurantDetailActivity : BaseActivity(),DetailView {

    private lateinit var restaurant: RestaurantVO
    private lateinit var mPopularFoodListAdapter : PopularFoodAdapter
    private lateinit var mFoodListAdapter : FoodListAdapter
    private lateinit var mPresenter : DetailPresenter

    companion object {
        fun newIntent(context:Context,restaurant: RestaurantVO): Intent {
            val intent =  Intent(context,RestaurantDetailActivity::class.java)
            intent.putExtra(RESTAURANT_EXTRA,restaurant)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        restaurant = intent.getSerializableExtra(RESTAURANT_EXTRA) as RestaurantVO

        setUpPresenter()
        setUpRecyclerView()
        setUpListener()
        mPresenter.onUiReady(this,restaurant)
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        // popular food list
        mPopularFoodListAdapter = PopularFoodAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvPopularChoices.adapter = mPopularFoodListAdapter
        rvPopularChoices.layoutManager = linearLayoutManager
        // food list
        mFoodListAdapter = FoodListAdapter(mPresenter)
        val foodLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvFoodList.adapter = mFoodListAdapter
        rvFoodList.layoutManager = foodLayoutManager
    }
    private fun setUpListener() {
        ivBack.setOnClickListener {
            mPresenter.onTapBack()
        }
        btnCart.setOnClickListener {
            mPresenter.onTapCart(restaurant)
        }
    }

    override fun displayDetail(restaurant: RestaurantVO) {
        Glide.with(this)
            .load(restaurant.image)
            .into(ivRestaurant)
        tvRestaurant.text = restaurant.name
        tvRating.text = restaurant.rating.toString()
        tvRatingCount.text = restaurant.ratingCount
        tvRestaurantType.text = restaurant.description
        tvLocation.text = restaurant.location
    }

    override fun displayPopularFood(foodList: List<FoodVO>) {
        val popularFoodList = arrayListOf<FoodVO>()
        foodList.forEach{
            if(it.popular==true) {
                popularFoodList.add(it)
            }
        }
        mPopularFoodListAdapter.setNewData(popularFoodList.toMutableList())
    }

    override fun displayFood(foodList: List<FoodVO>) {
        mFoodListAdapter.setNewData(foodList.toMutableList())
    }

    override fun navigateToHome() {
        finish()
    }

    override fun navigateToCart(restaurant: RestaurantVO) {
        startActivity(CartActivity.newIntent(this,restaurant))
    }

    override fun displayToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error,Snackbar.LENGTH_LONG)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroyCart()
    }
}