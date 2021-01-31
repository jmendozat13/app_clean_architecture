package com.afoxplus.data.source.network.di

import com.afoxplus.data.source.IChatBotDataSource
import com.afoxplus.data.source.network.ChatBotNetwork
import com.afoxplus.data.source.network.di.providers.providerChatBotService
import org.koin.dsl.module

val networkModule = module {
    single { providerChatBotService(get()) }
    single<IChatBotDataSource> { ChatBotNetwork() }
}