package com.afoxplus.data.di.providers

import okhttp3.Interceptor
import okhttp3.Response

private const val DEVICE_MODEL = "device"

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(DEVICE_MODEL, "${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}")
            .build()
        return chain.proceed(request)
    }
}
