package com.afoxplus.data.di

import com.afoxplus.data.repository.account.UserRepository
import com.afoxplus.data.repository.chat.ChatBotRepository
import com.afoxplus.data.source.di.localDataSourceModule
import com.afoxplus.data.source.di.networkDataSourceModule
import com.afoxplus.data.source.local.database.di.dataBaseModule
import com.afoxplus.data.source.network.core.di.networkModule
import com.afoxplus.data.source.network.core.di.retrofitModule
import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val repositoryModule = module {
    single<IChatBotRepository> { ChatBotRepository() }
    single<IUserRepository> { UserRepository() }
}

val loadRepositoryModule = loadKoinModules(
    listOf(
        retrofitModule,
        networkModule,
        localDataSourceModule,
        networkDataSourceModule,
        dataBaseModule,
        repositoryModule
    )
)