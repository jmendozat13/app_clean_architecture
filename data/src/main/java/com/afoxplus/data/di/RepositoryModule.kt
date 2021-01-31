package com.afoxplus.data.di

import com.afoxplus.data.repository.ChatBotRepository
import com.afoxplus.domain.repository.IChatBotRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IChatBotRepository> { ChatBotRepository() }
}