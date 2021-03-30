package com.afoxplus.data.di

import com.afoxplus.data.repository.chat.ChatBotRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<IChatBotRepository> { ChatBotRepository() }
}