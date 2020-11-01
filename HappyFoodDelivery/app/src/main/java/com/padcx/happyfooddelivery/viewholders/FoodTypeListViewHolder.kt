package com.padcx.happyfooddelivery.viewholders

import android.view.View
import kotlinx.android.synthetic.main.content_detail.view.*
import kotlinx.android.synthetic.main.food_type_list.view.*

class FoodTypeListViewHolder(itemView:View) :BaseViewHolder<String>(itemView){
    override fun bindData(data: String) {
        mData = data
        itemView.tvFood.text = data
    }
}