package com.padcx.happyfooddelivery.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.delegates.FoodItemDelegate
import kotlinx.android.synthetic.main.activity_restaurant_detail.view.*
import kotlinx.android.synthetic.main.popular_food_list.view.*

class PopularFoodListViewHolder(itemView:View,delegate:FoodItemDelegate):BaseViewHolder<FoodVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapFood(it)
            }
        }
    }
    override fun bindData(data: FoodVO) {
        if(data.popular==true) {
            mData = data
            Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.ivFood)
            itemView.tvFood.text = data.name
            itemView.tvPrice.text = "$${data.price.toString()}"
        }

    }
}