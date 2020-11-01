package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.delegates.FoodItemDelegate
import com.padcx.happyfooddelivery.viewholders.FoodListViewHolder

class FoodListAdapter(delegate:FoodItemDelegate):BaseRecyclerAdapter<FoodListViewHolder,FoodVO>() {

    val mDelegate : FoodItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_list,parent,false)
        return FoodListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}