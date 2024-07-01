package com.seroserod92.pokeapiperron.common

sealed class Resource<T>(val data: T? = null, val msg: String? =null) {
    class Loading<T>(data: T?  =null): Resource<T>(data)
    class Error<T>(msg: String, data: T? = null): Resource<T>(data, msg)
    class Success<T>(data: T):Resource<T>(data)
}