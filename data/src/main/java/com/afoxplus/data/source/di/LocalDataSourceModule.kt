package com.afoxplus.data.source.di

import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.data.source.local.database.account.UserLocalDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.data.source.local.database.chat.MessageLocalDataBase
import com.afoxplus.data.source.local.database.music.ITrackLocalDataSource
import com.afoxplus.data.source.local.database.music.TrackLocalDataSource
import org.koin.dsl.module

val localDataSourceModule = module {
    single<IMessageLocalDataSource> { MessageLocalDataBase() }
    single<ITrackLocalDataSource> { TrackLocalDataSource() }
    single<IUserLocalDataSource> { UserLocalDataSource() }
}