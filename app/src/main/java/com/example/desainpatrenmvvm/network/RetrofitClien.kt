@file:Suppress("unused", "unused")

package com.example.desainpatrenmvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("unused", "unused")
object RetrofitClien {

    private const val  BASE_URL = "https://rent-cars-api.herokuapp.com/"

    val instance : RestfulApi by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestfulApi::class.java)
    }
}