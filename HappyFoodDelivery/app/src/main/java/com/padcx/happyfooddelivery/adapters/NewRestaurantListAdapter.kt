package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import com.padcx.happyfooddelivery.viewholders.NewRestaurantViewHolder

class NewRestaurantListAdapter(delegate:RestaurantItemDelegate) : BaseRecyclerAdapter<NewRestaurantViewHolder,RestaurantVO>() {

    val mDelegate : RestaurantItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewRestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_restaurant_list,parent,false)
        return NewRestaurantViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: NewRestaurantViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}