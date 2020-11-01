package com.padcx.happyfooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.activities.RestaurantDetailActivity
import com.padcx.happyfooddelivery.adapters.FoodTypeListAdapter
import com.padcx.happyfooddelivery.adapters.RestaurantListAdapter
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.HomePresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.HomePresenterImpl
import com.padcx.happyfooddelivery.mvp.views.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment(),HomeView {

    private lateinit var mPresenter : HomePresenter
    private lateinit var mFoodTypeListAdapter : FoodTypeListAdapter
    private lateinit var mRestaurantListAdapter : RestaurantListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView() {
        // food type list
        mFoodTypeListAdapter = FoodTypeListAdapter()
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvFoodType.adapter = mFoodTypeListAdapter
        rvFoodType.layoutManager = linearLayoutManager
        // restaurant list
        mRestaurantListAdapter = RestaurantListAdapter(mPresenter)
        val restaurantLayoutManager =LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvRestaurantList.adapter = mRestaurantListAdapter
        rvRestaurantList.layoutManager = restaurantLayoutManager
    }

    override fun displayFoodTypeList(foodTypeList: List<String>) {
        mFoodTypeListAdapter.setNewData(foodTypeList.toMutableList())
    }

    override fun displayRestaurantList(restaurantList: List<RestaurantVO>) {
        mRestaurantListAdapter.setNewData(restaurantList.toMutableList())
    }

    override fun navigateToDetails(restaurant: RestaurantVO) {
        startActivity(RestaurantDetailActivity.newIntent(this.requireContext(),restaurant))
    }

    override fun showError(error: String) {
        view?.let { Snackbar.make(it,error,Snackbar.LENGTH_LONG) }
    }

}