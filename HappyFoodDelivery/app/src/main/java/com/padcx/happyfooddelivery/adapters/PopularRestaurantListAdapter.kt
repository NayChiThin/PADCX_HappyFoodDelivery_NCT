package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import com.padcx.happyfooddelivery.viewholders.PopularRestaurantListViewHolder

class PopularRestaurantListAdapter(delegate:RestaurantItemDelegate) : BaseRecyclerAdapter<PopularRestaurantListViewHolder,RestaurantVO>() {

    val mDelegate : RestaurantItemDelegate = delegate

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularRestaurantListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_restaurant_list,parent,false)
        return PopularRestaurantListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: PopularRestaurantListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}