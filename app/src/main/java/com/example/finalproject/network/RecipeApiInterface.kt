package com.example.finalproject.network

import com.example.finalproject.model.FoodEntity
import com.example.finalproject.model.FoodEntityItem
import retrofit2.Call
import retrofit2.http.GET
interface RecipeApiInterface {
    @GET("/recipes")
    fun getRecipe(): Call<FoodEntity>
}