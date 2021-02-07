package com.afoxplus.data.source.network.di.providers

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun providerRetrofit(
    baseUrl: String,
    client: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun providerOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    apiInterceptor: ApiInterceptor,
    context: Context
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(ChuckInterceptor(context))
        .addInterceptor(apiInterceptor)
        .build()
}

fun providerGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create()
}

fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}