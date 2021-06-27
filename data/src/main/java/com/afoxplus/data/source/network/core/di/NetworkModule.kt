package com.afoxplus.data.source.network.core.di

import com.afoxplus.data.source.network.core.di.providers.providerChatBotService
import org.koin.dsl.module

val networkModule = module {
    factory { providerChatBotService(get()) }
}