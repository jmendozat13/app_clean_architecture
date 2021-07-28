package com.afoxplus.data.source.network.di

import com.afoxplus.data.source.network.chat.service.IChatBotService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providerChatBotService(retrofit: Retrofit): IChatBotService =
        retrofit.create(IChatBotService::class.java)
}