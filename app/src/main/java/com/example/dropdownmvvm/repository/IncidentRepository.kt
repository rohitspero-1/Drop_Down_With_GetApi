package com.example.dropdownmvvm.repository

import android.icu.text.MessagePattern.ApostropheMode
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

    suspend fun postStateList(selectedStates:List<ServerModel>):ApiResult<Unit>{
        return try {
            val response = RetrofitClient.apiService.postSateList(selectedStates)
            if (response.isSuccessful){
                ApiResult(data = Unit)
            }else{
                ApiResult(error = ApiError(response.code(),response.message()))
            }
        }catch (e:Exception){
            ApiResult(error=ApiError(message = e.message))
        }
    }


}