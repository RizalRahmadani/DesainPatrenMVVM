package com.example.desainpatrenmvvm.network

import com.example.desainpatrenmvvm.model.ResponseDataCarItem
import retrofit2.http.GET

interface RestfulApi {
    @GET("admin/car")
    fun getAllCar() : retrofit2.Call<List<ResponseDataCarItem>>

    @GET("admin/car")
    fun getCar(): List<ResponseDataCarItem>

}