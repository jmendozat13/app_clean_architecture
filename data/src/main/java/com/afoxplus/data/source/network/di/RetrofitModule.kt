package com.afoxplus.data.source.network.di

import com.afoxplus.data.source.network.di.providers.*
import org.koin.dsl.module

const val BASE_URL = "BASE_URL"

val retrofitModule = module {
    factory { providerHttpLoggingInterceptor() }
    factory { providerGsonConverterFactory() }
    factory { ApiInterceptor() }
    factory { providerOkHttpClient(get(), get(), get()) }
    factory { providerRetrofit(getProperty(BASE_URL), get(), get()) }
}
