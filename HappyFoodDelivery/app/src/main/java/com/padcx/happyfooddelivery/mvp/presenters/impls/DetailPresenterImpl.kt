package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.impls.DetailModelImpl
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.DetailPresenter
import com.padcx.happyfooddelivery.mvp.views.DetailView

class DetailPresenterImpl:DetailPresenter,AbstractBasePresenter<DetailView>() {

    private val mDetailModel =
        DetailModelImpl

    override fun onTapBack() {
        mView.navigateToHome()
    }

    /*override fun onDataReady(restaurant: RestaurantVO) {
        mView.displayDetail(restaurant)
        restaurant.food?.let {
            mView.displayPopularFood(it)
            mView.displayFood(it)
        }
    }*/

    override fun onTapCart(restaurant: RestaurantVO) {
        mView.navigateToCart(restaurant)
    }

    override fun onDestroyCart() {
        mDetailModel.deleteCartItems()
    }

    override fun onUiReady(owner: LifecycleOwner,restaurant: RestaurantVO) {
        mView.displayDetail(restaurant)
        mDetailModel.getFoodList(restaurant.name?:"",
        onSuccess = {
            mView.displayFood(it)
            mView.displayPopularFood(it)
        },
        onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapFood(food: FoodVO) {
        mDetailModel.addFoodToCart(food)
        mView.displayToast("Added to Cart")
    }
}