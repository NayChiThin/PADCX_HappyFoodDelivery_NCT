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
import com.padcx.happyfooddelivery.adapters.NewRestaurantListAdapter
import com.padcx.happyfooddelivery.adapters.PopularRestaurantListAdapter
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.PopularHomePresenter
import com.padcx.happyfooddelivery.mvp.presenters.impls.PopularHomePresenterImpl
import com.padcx.happyfooddelivery.mvp.views.PopularHomeView
import kotlinx.android.synthetic.main.fragment_popular_home.*

class PopularHomeFragment : Fragment(),PopularHomeView {

    private lateinit var mPopularRestaurantListAdapter : PopularRestaurantListAdapter
    private lateinit var mNewRestaurantListAdapter: NewRestaurantListAdapter
    private lateinit var mPresenter : PopularHomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(PopularHomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    private fun setUpRecyclerView(){
        // popular restaurant list
        mPopularRestaurantListAdapter = PopularRestaurantListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvPopularRestaurant.adapter = mPopularRestaurantListAdapter
        rvPopularRestaurant.layoutManager = linearLayoutManager
        // new restaurant list
        mNewRestaurantListAdapter = NewRestaurantListAdapter(mPresenter)
        val newLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvNewRestaurant.adapter = mNewRestaurantListAdapter
        rvNewRestaurant.layoutManager = newLayoutManager
    }

    override fun displayPopularRestaurant(restaurantList: List<RestaurantVO>) {
        mPopularRestaurantListAdapter.setNewData(restaurantList.toMutableList())
    }

    override fun displayNewRestaurant(restaurantList: List<RestaurantVO>) {
        mNewRestaurantListAdapter.setNewData(restaurantList.toMutableList())
    }

    override fun navigateToDetails(restaurant: RestaurantVO) {
        startActivity(RestaurantDetailActivity.newIntent(this.requireContext(),restaurant))
    }

    override fun showError(error: String) {
        view?.let { Snackbar.make(it,error, Snackbar.LENGTH_LONG) }
    }

}