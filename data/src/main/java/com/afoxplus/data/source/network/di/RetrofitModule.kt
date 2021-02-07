package com.afoxplus.data.source.network.di

import com.afoxplus.data.source.network.di.providers.*
import org.koin.dsl.module

const val BASE_URL = "BASE_URL"

val retrofitModule = module {
    single { providerHttpLoggingInterceptor() }
    single { providerGsonConverterFactory() }
    single { ApiInterceptor() }
    single { providerOkHttpClient(get(), get(), get()) }
    single { providerRetrofit(getProperty(BASE_URL), get(), get()) }
}
