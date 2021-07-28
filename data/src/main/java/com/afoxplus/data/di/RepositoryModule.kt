package com.afoxplus.data.di

import com.afoxplus.data.repository.account.UserRepository
import com.afoxplus.data.repository.chat.ChatBotRepository
import com.afoxplus.data.source.local.database.account.IUserLocalDataSource
import com.afoxplus.data.source.local.database.chat.IMessageLocalDataSource
import com.afoxplus.data.source.network.chat.IChatBotNetworkDataSource
import com.afoxplus.domain.repository.account.IUserRepository
import com.afoxplus.domain.repository.chat.IChatBotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideChatBotRepository(
        chatBotNetworkDataSource: IChatBotNetworkDataSource,
        messageLocalDataSource: IMessageLocalDataSource
    ): IChatBotRepository = ChatBotRepository(chatBotNetworkDataSource, messageLocalDataSource)

    @Provides
    fun provideUserRepository(userLocalDataSource: IUserLocalDataSource): IUserRepository =
        UserRepository(userLocalDataSource)
}