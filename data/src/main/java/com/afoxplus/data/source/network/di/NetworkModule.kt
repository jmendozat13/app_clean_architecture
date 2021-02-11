package com.afoxplus.data.source.network.di

import com.afoxplus.data.source.network.di.providers.providerChatBotService
import org.koin.dsl.module

val networkModule = module {
    factory { providerChatBotService(get()) }
}