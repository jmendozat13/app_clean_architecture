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
    single<VerifyInitialMessage> {
        VerifyInitialMessageImpl(
            get<IChatBotRepository>(),
            get<IUserRepository>()
        )
    }
    single<SendBotMessage> {
        SendBotMessageImpl(
            get<IChatBotRepository>(),
            get<IUserRepository>()
        )
    }
}