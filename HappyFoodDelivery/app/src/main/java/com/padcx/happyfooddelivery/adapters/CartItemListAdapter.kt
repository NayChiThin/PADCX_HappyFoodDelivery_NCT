package com.padcx.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.happyfooddelivery.R
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.viewholders.CartIemListViewHolder

class CartItemListAdapter : BaseRecyclerAdapter<CartIemListViewHolder,FoodVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartIemListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_list,parent,false)
        return CartIemListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartIemListViewHolder, position: Int) {
        holder.bindData(mData[position])
    }
}