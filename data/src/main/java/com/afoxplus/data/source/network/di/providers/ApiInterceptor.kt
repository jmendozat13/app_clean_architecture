package com.afoxplus.data.source.network.di.providers

import okhttp3.Interceptor
import okhttp3.Response

private const val DEVICE_MODEL = "device"

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(DEVICE_MODEL, "Android")
            //"${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}")
            .addHeader("username", "jmendozat13")
            .addHeader("ip", "localhost")
            .addHeader("aditionalInfo", "mobile")
            .build()
        return chain.proceed(request)
    }
}
