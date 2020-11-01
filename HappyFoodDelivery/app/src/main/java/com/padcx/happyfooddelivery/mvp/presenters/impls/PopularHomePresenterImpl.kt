package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.impls.HomeModelImpl
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.PopularHomePresenter
import com.padcx.happyfooddelivery.mvp.views.PopularHomeView

class PopularHomePresenterImpl : PopularHomePresenter,AbstractBasePresenter<PopularHomeView>() {

    private val mHappyFoodModel =
        HomeModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mHappyFoodModel.getPopularRestaurants(
            onSuccess = {
                mView.displayPopularRestaurant(it)
            },
            onFailure = {
                mView.showError(it)
            }
        )
        mHappyFoodModel.getNewRestaurants(
            onSuccess = {
                mView.displayNewRestaurant(it)
            },
            onFailure = {
                mView.showError(it)
            }
        )
    }


    override fun onTapRestaurant(restaurant: RestaurantVO) {
        mView.navigateToDetails(restaurant)
    }
}