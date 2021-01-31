package com.afoxplus.data.source.util.extension

import com.afoxplus.data.source.util.HttpError
import com.afoxplus.domain.exceptions.GenericException
import retrofit2.Response

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(action)
    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (HttpError) -> Unit) {
    if (!isSuccessful) errorBody()?.run {
        action(HttpError(GenericException(), code()))
    }
}