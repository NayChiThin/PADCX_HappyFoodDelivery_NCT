package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.delegates.FoodItemDelegate
import com.padcx.happyfooddelivery.viewholders.PopularFoodListViewHolder

class PopularFoodAdapter(delegate: FoodItemDelegate):BaseRecyclerAdapter<PopularFoodListViewHolder,FoodVO>() {

    val mDelegate : FoodItemDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFoodListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_food_list,parent,false)
        return PopularFoodListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: PopularFoodListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}