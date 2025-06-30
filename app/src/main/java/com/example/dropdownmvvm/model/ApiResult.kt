package com.example.dropdownmvvm.model

data class ApiResult<T>(
    val data: T? = null,
    val error: ApiError? = null,
    val loading: Boolean = false
)

data class ApiError(
    val code: Int? = null,
    val message: String? = null
)