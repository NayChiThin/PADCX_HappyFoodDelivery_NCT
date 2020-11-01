package com.padcx.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.happyfooddelivery.data.models.CartModelImpl
import com.padcx.happyfooddelivery.data.models.HomeModelImpl
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.padcx.happyfooddelivery.mvp.presenters.CartPresenter
import com.padcx.happyfooddelivery.mvp.views.CartView

class CartPresenterImpl : CartPresenter,AbstractBasePresenter<CartView>() {

    private val mCartModel = CartModelImpl
    private var totalPrice = 0


    override fun onTapBack() {
        mView.navigateToDetail()
    }

    override fun onTapAddFood() {
        mView.navigateToDetail()
    }

    override fun onTapCheckOut() {
        mView.displaySubtotal(totalPrice)
    }

    override fun onDataReady(restaurant: RestaurantVO) {
        mView.displayRestaurant(restaurant)
    }

    override fun onDestroyCartItems() {
        mCartModel.deleteCartItems()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mCartModel.getCartItems(
            onSuccess = {
                mView.displayCartItemList(it)
                totalPrice = 0
                it.forEach {food->
                    totalPrice += food.price?:0
                }
                mView.displaySubtotal(totalPrice)
            },
            onFailure = {
                mView.showError(it)
            }
        )
    }
}