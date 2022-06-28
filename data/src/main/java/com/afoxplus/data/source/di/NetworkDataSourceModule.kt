package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.chat.ChatBotNetworkDataSource
import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.network.user.IUserNetworkDataSource
import com.afoxplus.data.source.network.user.UserNetworkDataSource
import org.koin.dsl.module


val networkDataSourceModule = module {
    single<IChatBotNetworkDataSource> { ChatBotNetworkDataSource() }
    single<IUserNetworkDataSource> { UserNetworkDataSource() }
}