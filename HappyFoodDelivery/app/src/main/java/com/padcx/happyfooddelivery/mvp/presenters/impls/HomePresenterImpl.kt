package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.HomeModelImpl
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.HomePresenter
import com.padcx.happyfooddelivery.mvp.views.HomeView

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {

    private val mHappyFoodModel = HomeModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mView.displayFoodTypeList(arrayListOf("Offers","Burgers","Asian","Pizza"))
        mHappyFoodModel.getRestaurants(
            onSuccess = {
                mView.displayRestaurantList(it)
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