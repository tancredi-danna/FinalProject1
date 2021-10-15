package com.example.finalproject.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RecipeApiService {
    companion object{
        val BASE_URL = "https://usman-recipes.herokuapp.com/api"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApiInterface::class.java)
    }
}