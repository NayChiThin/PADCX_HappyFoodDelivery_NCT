package com.padcx.happyfooddelivery.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.delegates.RestaurantItemDelegate
import kotlinx.android.synthetic.main.restaurant_list.view.*

class RestaurantListViewHolder(itemView:View,delegate:RestaurantItemDelegate) : BaseViewHolder<RestaurantVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapRestaurant(it)
            }
        }
    }
    override fun bindData(data: RestaurantVO) {
        mData = data

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivRestaurant)
        itemView.tvRestaurant.text = data.name
        itemView.tvDeliverTime.text = data.deliveryTime
        itemView.tvRating.text = data.rating.toString()
        itemView.tvRatingCount.text = data.ratingCount
        itemView.tvRestaurantType.text = data.description
    }

}