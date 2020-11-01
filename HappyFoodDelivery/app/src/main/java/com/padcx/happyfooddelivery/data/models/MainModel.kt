package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.remoteconfig.FirebaseRemoteConfigManager

interface MainModel {
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager
    fun getLayoutType():Int
    fun setUpRemoteConfigWithDefaultValues()
    fun fetchRemoteConfigs()
}