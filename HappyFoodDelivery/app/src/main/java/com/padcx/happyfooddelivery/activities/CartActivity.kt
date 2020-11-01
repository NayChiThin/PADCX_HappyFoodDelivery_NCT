package com.padcx.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.adapters.CartItemListAdapter
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.fragments.BottomSheetFragment
import com.padcx.happyfooddelivery.mvp.presenters.CartPresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.CartPresenterImpl
import com.padcx.happyfooddelivery.mvp.views.CartView
import com.padcx.happyfooddelivery.utils.RESTAURANT_EXTRA
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : BaseActivity(),CartView {

    private lateinit var restaurant: RestaurantVO
    private lateinit var mCartItemListAdapter : CartItemListAdapter
    private lateinit var mPresenter : CartPresenter
    private lateinit var bottomSheetDialogFragment: BottomSheetFragment

    companion object {
        fun newIntent(context:Context,restaurant:RestaurantVO) : Intent {
            val intent = Intent(context,CartActivity::class.java)
            intent.putExtra(RESTAURANT_EXTRA,restaurant)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        restaurant = intent.getSerializableExtra(RESTAURANT_EXTRA) as RestaurantVO

        setUpPresenter()
        setUpRecyclerView()
        setUpListener()
        mPresenter.onDataReady(restaurant)
        mPresenter.onUiReady(this)
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CartPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        mCartItemListAdapter = CartItemListAdapter()
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvCartItems.adapter = mCartItemListAdapter
        rvCartItems.layoutManager = linearLayoutManager
    }
    private fun setUpListener() {
        ivBack.setOnClickListener {
            mPresenter.onTapBack()
        }
        tvAddFood.setOnClickListener {
            mPresenter.onTapAddFood()
        }
        btnCheckOut.setOnClickListener {
            mPresenter.onDestroyCartItems()
            bottomSheetDialogFragment = BottomSheetFragment()
            bottomSheetDialogFragment.show(supportFragmentManager,bottomSheetDialogFragment.tag)
            mPresenter.onTapCheckOut()
        }
    }

    override fun displayRestaurant(restaurant: RestaurantVO) {
        tvRestaurant.text = restaurant.name
        Glide.with(this)
            .load(restaurant.image)
            .into(ivRestaurant)
        tvRestaurantType.text = restaurant.description
        tvRating.text = restaurant.rating.toString()
        tvRatingCount.text = restaurant.ratingCount
        tvLocation.text = restaurant.location

    }

    override fun navigateToDetail() {
        finish()
    }

    override fun displayCartItemList(itemList:List<FoodVO>) {
        mCartItemListAdapter.setNewData(itemList.toMutableList())
    }

    override fun displaySubtotal(totalPrice: Int) {
        tvSubtotalPrice.text = "$${totalPrice}"
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.relativeLayout),error, Snackbar.LENGTH_LONG)
    }
}