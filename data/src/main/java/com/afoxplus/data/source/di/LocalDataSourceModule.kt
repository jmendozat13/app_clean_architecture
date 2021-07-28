package com.afoxplus.data.source.di

import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.data.source.local.database.account.UserLocalDataSource
import com.afoxplus.data.source.local.database.account.dao.UserDao
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.data.source.local.database.chat.MessageLocalDataSource
import com.afoxplus.data.source.local.database.chat.dao.MessageDao
import com.afoxplus.data.source.local.database.chat.dao.OptionMessageDao
import com.afoxplus.data.source.local.database.music.ITrackLocalDataSource
import com.afoxplus.data.source.local.database.music.TrackLocalDataSource
import com.afoxplus.data.source.local.database.music.dao.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    fun provideMessageLocalDataSource(
        messageDao: MessageDao,
        optionMessageDao: OptionMessageDao
    ): IMessageLocalDataSource = MessageLocalDataSource(messageDao, optionMessageDao)

    @Provides
    fun provideTrackLocalDataSource(trackDao: TrackDao): ITrackLocalDataSource =
        TrackLocalDataSource(trackDao)

    @Provides
    fun provideUserLocalDataSource(userDao: UserDao): IUserLocalDataSource =
        UserLocalDataSource(userDao)
}