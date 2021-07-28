package com.afoxplus.data.source.network.core

import android.content.Context
import com.afoxplus.data.source.network.core.extension.isAirplaneModeActive
import com.afoxplus.data.source.network.core.extension.isConnected
import com.afoxplus.domain.core.exceptions.ApiNetworkException
import com.afoxplus.domain.core.exceptions.NetworkException
import okhttp3.Interceptor
import okhttp3.Response

private const val DEVICE_MODEL = "device"

class ApiInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!context.isConnected() || context.isAirplaneModeActive()) {
            throw NetworkException()
        }
        val requestBuilder = chain.request().newBuilder()
            .addHeader(DEVICE_MODEL, "${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}")
            .build()
        val response = chain.proceed(requestBuilder)
        if (!response.isSuccessful)
            throw ApiNetworkException(code = response.code, message = response.message)
        return response
    }
}
