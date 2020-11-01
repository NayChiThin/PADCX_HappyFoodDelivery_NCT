package com.padcx.happyfooddelivery.data.vos

import java.io.Serializable

class FoodVO(
    var description : String? = null,
    var image : String? = null,
    var name : String? = null,
    var popular : Boolean? = null,
    var price :Int? = null
) : Serializable