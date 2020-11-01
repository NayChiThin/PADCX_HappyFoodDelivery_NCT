package com.padcx.happyfooddelivery.delegates

import com.padcx.happyfooddelivery.data.vos.FoodVO

interface FoodItemDelegate {
    fun onTapFood(food:FoodVO)
}