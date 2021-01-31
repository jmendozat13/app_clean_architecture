package com.afoxplus.domain.di

import com.afoxplus.domain.usecases.ChatBotUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCaseModule = module {
    single { Dispatchers.IO }
    single { ChatBotUseCase() }
}