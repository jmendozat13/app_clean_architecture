package com.afoxplus.data.di

import com.afoxplus.data.di.providers.ApiInterceptor
import com.afoxplus.data.di.providers.providerGsonConverterFactory
import com.afoxplus.data.di.providers.providerOkHttpClient
import com.afoxplus.data.di.providers.providerRetrofit
import org.koin.dsl.module

const val BASE_URL = "BASE_URL"

val retrofitModule = module {
    single { providerGsonConverterFactory() }
    single { ApiInterceptor() }
    single { providerOkHttpClient(get(), get()) }
    single { providerRetrofit(getProperty(BASE_URL), get(), get()) }
}
