package com.padcx.happyfooddelivery.viewholders

import android.view.View
import com.padcx.happyfooddelivery.data.vos.FoodVO
import kotlinx.android.synthetic.main.cart_item_list.view.*

class CartIemListViewHolder(itemView:View) : BaseViewHolder<FoodVO>(itemView) {

    override fun bindData(data: FoodVO) {
        mData = data
        itemView.tvFoodName.text = "${data.name} x 1"
        itemView.tvPrice.text = "$${data.price}"
    }
}