package com.afoxplus.domain.di

import com.afoxplus.domain.usecases.account.UserUseCase
import com.afoxplus.domain.usecases.chat.ChatBotUseCase
import com.afoxplus.domain.usecases.chat.VerifyInitialMessage
import com.afoxplus.domain.usecases.chat.VerifyInitialMessageImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { ChatBotUseCase() }
    single { UserUseCase() }
    factory<VerifyInitialMessage> { VerifyInitialMessageImpl(get<ChatBotUseCase>()) }
}