package com.padcx.happyfooddelivery.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class RestaurantVO(
    var deliveryTime : String? = null,
    var description : String? = null,
    var food : List<FoodVO>? = null,
    var image : String? = null,
    var location : String? = null,
    var name : String? = null,
    var new : Boolean? = null,
    var popular : Boolean? = null,
    var rating : Float? = null,
    var ratingCount : String? = null
) : Serializable