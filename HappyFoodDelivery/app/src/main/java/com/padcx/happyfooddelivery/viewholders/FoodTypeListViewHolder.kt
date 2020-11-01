package com.padcx.happyfooddelivery.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happyfooddelivery.data.vos.FoodTypeVO
import kotlinx.android.synthetic.main.content_detail.view.*
import kotlinx.android.synthetic.main.food_type_list.view.*

class FoodTypeListViewHolder(itemView:View) :BaseViewHolder<FoodTypeVO>(itemView){
    override fun bindData(data: FoodTypeVO) {
        mData = data
        itemView.tvFood.text = data.name
        Glide.with(itemView)
            .load(data.image)
            .into(itemView.ivFood)
    }
}