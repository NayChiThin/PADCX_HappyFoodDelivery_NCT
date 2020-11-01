package com.padcx.happyfooddelivery.network

import android.graphics.Bitmap
import android.util.Log
import androidx.core.net.toUri
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.padcx.happyfooddelivery.data.vos.FoodTypeVO
import com.padcx.happyfooddelivery.data.vos.FoodVO
import com.padcx.happyfooddelivery.data.vos.RestaurantVO
import com.padcx.happyfooddelivery.network.auth.AuthManager
import com.padcx.happyfooddelivery.network.auth.FirebaseAuthManager
import java.io.ByteArrayOutputStream
import java.util.*

object CloudFirestoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    private val storageRef = storage.reference
    private val mAuthManager : AuthManager = FirebaseAuthManager
    val restaurantList : MutableList<RestaurantVO> = arrayListOf()

    override fun getRestaurants(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?: run {
                    val result = value?.documents ?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val restaurant = RestaurantVO()
                        restaurant.name = data?.get("name") as String
                        restaurant.deliveryTime = data["deliveryTime"] as String
                        restaurant.description = data["description"] as String
                        restaurant.image = data["image"] as String
                        restaurant.location = data["location"] as String
                        restaurant.new = data["new"] as Boolean
                        restaurant.popular = data["popular"] as Boolean
                        restaurant.rating = (data["rating"] as Double).toFloat()
                        restaurant.ratingCount = data["ratingCount"] as String

                        restaurantList.add(restaurant)
                    }
                    onSuccess(restaurantList)
                }
            }
    }

    override fun getPopularRestaurants(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        db.collection("restaurants")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?: run {
                    val restaurantList : MutableList<RestaurantVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val restaurant = RestaurantVO()
                        restaurant.name = data?.get("name") as String
                        restaurant.deliveryTime = data["deliveryTime"] as String
                        restaurant.description = data["description"] as String
                        restaurant.image = data["image"] as String
                        restaurant.location = data["location"] as String
                        restaurant.new = data["new"] as Boolean
                        restaurant.popular = data["popular"] as Boolean
                        restaurant.rating = (data["rating"] as Double).toFloat()
                        restaurant.ratingCount = data["ratingCount"] as String
                        if(restaurant.popular == true) {
                            restaurantList.add(restaurant)
                        }
                    }
                    onSuccess(restaurantList)
                }
            }
    }

    override fun getNewRestaurants(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {

        db.collection("restaurants")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?: run {
                    val restaurantList : MutableList<RestaurantVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val restaurant = RestaurantVO()
                        restaurant.name = data?.get("name") as String
                        restaurant.deliveryTime = data["deliveryTime"] as String
                        restaurant.description = data["description"] as String
                        restaurant.image = data["image"] as String
                        restaurant.location = data["location"] as String
                        restaurant.new = data["new"] as Boolean
                        restaurant.popular = data["popular"] as Boolean
                        restaurant.rating = (data["rating"] as Double).toFloat()
                        restaurant.ratingCount = data["ratingCount"] as String
                        if(restaurant.new == true) {
                            restaurantList.add(restaurant)
                        }
                    }
                    onSuccess(restaurantList)
                }
            }
    }

    override fun addFoodToCart(food: FoodVO) {

        val foodMap = hashMapOf(
            "name" to food.name,
            "description" to food.description,
            "image" to food.image,
            "popular" to food.popular,
            "price" to food.price
        )
        db.collection("cart")
            .document()
            .set(foodMap)
            .addOnSuccessListener { Log.d("Success","Successfully added food to cart") }
            .addOnFailureListener { Log.d("Failure","Failed to add food to cart") }
    }

    override fun getCartItems(
        onSuccess: (cartItems: List<FoodVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("cart")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?:run {
                    val itemList : MutableList<FoodVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for (document in result) {
                        val data = document.data
                        val food = FoodVO()
                        food.description = data?.get("description") as String
                        food.name = data["name"] as String
                        food.image = data["image"] as String
                        food.price = (data["price"] as Long).toInt()
                        food.popular = data["popular"] as Boolean
                        itemList.add(food)
                    }
                    onSuccess(itemList)
                }
            }
    }

    override fun deleteCartItems() {
        db.collection("cart")
            .get()
            .addOnSuccessListener {result ->
                result.forEach{
                    it.reference.delete()
                }
            }

    }

    override fun uploadProfileImage(image: Bitmap) {
        var imageUrl = ""
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG,100,baos)
        val data = baos.toByteArray()

        val imageRef = storageRef.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener{

        }.addOnSuccessListener { taskSnapshot ->  }
        val urlTask = uploadTask.continueWithTask{
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener { task->
            imageUrl = task.result?.toString() ?: ""
            mAuthManager.updatePhotoUrl(imageUrl.toUri())

        }
    }

    override fun getFoodList(
        restaurantName:String,
        onSuccess: (foodList: List<FoodVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants")
            .document(restaurantName)
            .collection("food")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?:run {
                    val result = value?.documents?: arrayListOf()
                    val foodList : MutableList<FoodVO> = arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val food = FoodVO()
                        food.name = data?.get("name") as String
                        food.description = data["description"] as String
                        food.image = data["image"] as String
                        food.price = (data["price"] as Long).toInt()
                        food.popular = data["popular"] as Boolean
                        foodList.add(food)
                    }
                    onSuccess(foodList)
                }
            }
    }

    override fun getFoodType(
        onSuccess: (foodTypes: List<FoodTypeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("foodType")
            .addSnapshotListener{value,error->
                error?.let {
                    onFailure(it.message?:"Please check internet connection")
                }?: run {
                    val foodTypeList : MutableList<FoodTypeVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()
                    for(document in result) {
                        val data = document.data
                        val foodType = FoodTypeVO()
                        foodType.name = data?.get("name") as String
                        foodType.image = data["image"] as String
                        foodTypeList.add(foodType)
                    }
                    onSuccess(foodTypeList)
                }
            }
    }
}