package com.padcx.happyfooddelivery.delegates

import com.padcx.happyfooddelivery.data.vos.RestaurantVO

interface RestaurantItemDelegate {
    fun onTapRestaurant(restaurant:RestaurantVO)
}