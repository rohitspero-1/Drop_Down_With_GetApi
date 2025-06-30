package com.example.dropdownmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dropdownmvvm.model.ApiResult
import com.example.dropdownmvvm.model.ServerModel
import com.example.dropdownmvvm.repository.IncidentRepository
import kotlinx.coroutines.launch

class AssessmentViewModel : ViewModel() {
    val obsStateList = MutableLiveData<ApiResult<List<ServerModel>>>()
    private val repository = IncidentRepository()

    fun getStateListFromApi() {
        obsStateList.postValue(ApiResult(loading = true))
        viewModelScope.launch {
            val result = repository.getStateList()
            obsStateList.postValue(result)
        }
    }
}