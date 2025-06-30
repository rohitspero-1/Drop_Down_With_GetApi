package com.example.dropdownmvvm.network

import com.example.dropdownmvvm.model.ServerModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getStateList(): Response<List<ServerModel>>
}