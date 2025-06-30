package com.example.dropdownmvvm.repository

import com.example.dropdownmvvm.model.ApiError
import com.example.dropdownmvvm.model.ApiResult
import com.example.dropdownmvvm.model.ServerModel
import com.example.dropdownmvvm.network.RetrofitClient

class IncidentRepository {
    suspend fun getStateList(): ApiResult<List<ServerModel>> {
        return try {
            val response = RetrofitClient.apiService.getStateList()
            if (response.isSuccessful) {
                ApiResult(data = response.body())
            } else {
                ApiResult(error = ApiError(response.code(), response.message()))
            }
        } catch (e: Exception) {
            ApiResult(error = ApiError(message = e.message))
        }
    }
}