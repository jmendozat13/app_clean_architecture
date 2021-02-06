package com.afoxplus.data.source.di

import com.afoxplus.data.source.IChatBotDataSource
import com.afoxplus.data.source.IMessageDataSource
import com.afoxplus.data.source.local.database.MessageDataBase
import com.afoxplus.data.source.network.ChatBotNetwork
import org.koin.dsl.module

val dataSourceModule = module {
    single<IChatBotDataSource> { ChatBotNetwork() }
    single<IMessageDataSource> { MessageDataBase() }
}