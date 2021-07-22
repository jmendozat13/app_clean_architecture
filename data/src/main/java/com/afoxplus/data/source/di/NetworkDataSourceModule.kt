package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.chat.ChatBotNetworkDataSource
import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import org.koin.dsl.module


val networkDataSourceModule = module {
    single<IChatBotNetworkDataSource> { ChatBotNetworkDataSource() }
}