package com.afoxplus.data.di

import com.afoxplus.data.repository.chat.ChatBotRepository
import com.afoxplus.data.source.di.dataSourceModule
import com.afoxplus.data.source.local.database.core.di.dataBaseModule
import com.afoxplus.data.source.network.core.di.networkModule
import com.afoxplus.data.source.network.core.di.retrofitModule
import com.afoxplus.domain.repository.chat.IChatBotRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val repositoryModule = module {
    factory<IChatBotRepository> { ChatBotRepository() }
}

val loadRepositoryModule = loadKoinModules(
    listOf(
        retrofitModule,
        networkModule,
        dataSourceModule,
        dataBaseModule,
        repositoryModule
    )
)