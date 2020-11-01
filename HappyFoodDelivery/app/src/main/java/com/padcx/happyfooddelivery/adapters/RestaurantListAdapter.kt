package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import com.padcx.happyfooddelivery.viewholders.RestaurantListViewHolder

class RestaurantListAdapter(delegate:RestaurantItemDelegate) : BaseRecyclerAdapter<RestaurantListViewHolder,RestaurantVO>() {

    val mDelegate : RestaurantItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list,parent,false)
        return RestaurantListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: RestaurantListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}