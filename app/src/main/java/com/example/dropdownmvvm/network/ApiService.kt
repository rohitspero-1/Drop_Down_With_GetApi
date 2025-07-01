package com.example.dropdownmvvm.network

import com.example.dropdownmvvm.model.ServerModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    suspend fun getStateList(): Response<List<ServerModel>>

    @POST("users")
    suspend fun postSateList(@Body selectedStates:List<ServerModel>):Response<Unit>


}