package com.padcx.happyfooddelivery.data.models

import com.padcx.happyfooddelivery.network.remoteconfig.FirebaseRemoteConfigManager

object MainModelImpl:MainModel {
    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun getLayoutType(): Int {
        return mFirebaseRemoteConfigManager.getLayoutType()
    }

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }
}