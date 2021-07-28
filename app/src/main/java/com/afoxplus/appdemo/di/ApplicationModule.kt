package com.afoxplus.appdemo.di

import com.afoxplus.appdemo.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String = BuildConfig.BASE_URL
}