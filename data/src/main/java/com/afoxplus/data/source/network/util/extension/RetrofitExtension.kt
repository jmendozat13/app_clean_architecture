package com.afoxplus.data.source.network.util.extension

import com.afoxplus.domain.exceptions.ApiNetworkException
import retrofit2.Response

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (ApiNetworkException) -> Unit) {
    if (!isSuccessful) errorBody()?.run {
        action(ApiNetworkException(name = message(), message = message(), code = code()))
    }
}