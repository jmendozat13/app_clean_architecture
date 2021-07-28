package com.afoxplus.data.source.local.database.di

import android.content.Context
import com.afoxplus.data.source.local.database.account.dao.UserDao
import com.afoxplus.data.source.local.database.chat.dao.MessageDao
import com.afoxplus.data.source.local.database.chat.dao.OptionMessageDao
import com.afoxplus.data.source.local.database.core.AppDemoDataBase
import com.afoxplus.data.source.local.database.music.dao.TrackDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Provides
    fun provideMessageDao(appDataBase: AppDemoDataBase): MessageDao = appDataBase.messageDao

    @Provides
    fun provideTrackDao(appDataBase: AppDemoDataBase): TrackDao = appDataBase.trackDao

    @Provides
    fun provideOptionMessageDao(appDataBase: AppDemoDataBase): OptionMessageDao =
        appDataBase.optionMessageDao

    @Provides
    fun provideUserDao(appDataBase: AppDemoDataBase): UserDao = appDataBase.userDao

    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDemoDataBase {
        return AppDemoDataBase.getDatabase(context, "${context.packageName}.db")
    }
}