package com.afoxplus.domain.di

import com.afoxplus.domain.usecases.account.UserUseCase
import com.afoxplus.domain.usecases.chat.ChatBotUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { ChatBotUseCase() }
    single { UserUseCase() }
}