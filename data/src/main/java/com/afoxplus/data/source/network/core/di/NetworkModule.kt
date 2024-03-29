package com.afoxplus.data.source.network.core.di

import com.afoxplus.data.source.network.core.di.providers.providerChatBotService
import com.afoxplus.data.source.network.core.di.providers.providerUserService
import org.koin.dsl.module

val networkModule = module {
    single { providerChatBotService(get()) }
    single { providerUserService(get()) }
}