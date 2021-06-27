package com.afoxplus.data.source.di

import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.data.source.local.database.chat.MessageLocalDataBase
import com.afoxplus.data.source.local.database.music.TrackLocalDataSource
import com.afoxplus.data.source.local.database.music.ITrackLocalDataSource
import com.afoxplus.data.source.network.chat.ChatBotNetworkDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory<IChatBotNetworkDataSource> { ChatBotNetworkDataSource() }
    factory<IMessageLocalDataSource> { MessageLocalDataBase() }
    factory<ITrackLocalDataSource> { TrackLocalDataSource() }
}