package com.afoxplus.data.di.providers

import okhttp3.Interceptor
import okhttp3.Response


class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().build()
        return chain.proceed(request)
    }
}
