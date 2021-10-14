package com.example.finalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.model.FoodEntity
import com.example.finalproject.network.RecipeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel :ViewModel(){
    private val recipeApiService = RecipeApiService
    val randomDishLoadingError = MutableLiveData<Boolean>()
    val recipe = MutableLiveData<FoodEntity>()

    fun getRecipeFromApi(){

        recipeApiService.retrofit.getRecipe().enqueue(object : Callback<FoodEntity> {
            override fun onResponse(call: Call<FoodEntity>, response: Response<FoodEntity>) {
                if(response.isSuccessful){
                    recipe.value = response.body()
                }
            }

            override fun onFailure(call: Call<FoodEntity>, t: Throwable) {
                randomDishLoadingError.value = true

            }


        })

    }
}