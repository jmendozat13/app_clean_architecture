package com.afoxplus.domain.di

import com.afoxplus.domain.usecases.ChatBotUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { ChatBotUseCase() }
}