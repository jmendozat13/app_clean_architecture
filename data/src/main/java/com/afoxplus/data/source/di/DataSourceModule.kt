package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.IMessageLocalDataSource
import com.afoxplus.data.source.local.database.implement.MessageLocalDataBase
import com.afoxplus.data.source.network.implement.ChatBotNetworkNetwork
import org.koin.dsl.module

val dataSourceModule = module {
    factory<IChatBotNetworkDataSource> { ChatBotNetworkNetwork() }
    factory<IMessageLocalDataSource> { MessageLocalDataBase() }
}