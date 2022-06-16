package com.afoxplus.domain.di

import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository
import com.afoxplus.domain.usecases.account.UserUseCase
import com.afoxplus.domain.usecases.chat.*
import com.afoxplus.domain.usecases.chat.VerifyInitialMessageImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { ChatBotUseCase() }
    single { UserUseCase() }
    factory<VerifyInitialMessage> {
        VerifyInitialMessageImpl(
            get<IChatBotRepository>(),
            get<IUserRepository>()
        )
    }
    factory<SendBotMessage> {
        SendBotMessageImpl(
            get<IChatBotRepository>(),
            get<IUserRepository>()
        )
    }
}