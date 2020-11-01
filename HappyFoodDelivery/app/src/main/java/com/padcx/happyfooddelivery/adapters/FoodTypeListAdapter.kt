package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.FoodTypeVO
import com.padcx.happyfooddelivery.viewholders.FoodTypeListViewHolder

class FoodTypeListAdapter : BaseRecyclerAdapter<FoodTypeListViewHolder,FoodTypeVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTypeListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_type_list,parent,false)
        return FoodTypeListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodTypeListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}