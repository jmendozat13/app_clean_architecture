package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.chat.ChatBotNetworkDataSource
import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.network.chat.service.IChatBotService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkDataSourceModule {

    @Provides
    fun provideChatBotNetworkDataSource(chatBotService: IChatBotService): IChatBotNetworkDataSource =
        ChatBotNetworkDataSource(chatBotService)
}