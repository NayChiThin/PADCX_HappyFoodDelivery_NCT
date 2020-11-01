package com.padcx.happyfooddelivery.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.delegates.FoodItemDelegate
import kotlinx.android.synthetic.main.food_list.view.*

class FoodListViewHolder(itemView:View,delegate:FoodItemDelegate):BaseViewHolder<FoodVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapFood(it)
            }
        }
    }
    override fun bindData(data: FoodVO) {
        mData = data
        itemView.tvFoodName.text = data.name
        itemView.tvPrice.text = "$${data.price.toString()}"
        itemView.tvDescription.text = data.description
        if(data.popular==false) {
            itemView.tvPopular.visibility = View.GONE
            itemView.ivStar.visibility = View.GONE
        }
    }
}