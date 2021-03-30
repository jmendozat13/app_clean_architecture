package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.IMessageLocalDataSource
import com.afoxplus.data.source.local.database.implement.chat.MessageLocalDataBase
import com.afoxplus.data.source.network.implement.chat.ChatBotNetworkNetwork
import org.koin.dsl.module

val dataSourceModule = module {
    factory<IChatBotNetworkDataSource> { ChatBotNetworkNetwork() }
    factory<IMessageLocalDataSource> { MessageLocalDataBase() }
}