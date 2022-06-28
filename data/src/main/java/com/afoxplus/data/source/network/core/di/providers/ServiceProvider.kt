package com.afoxplus.data.source.network.core.di.providers

import com.afoxplus.data.source.network.chat.service.IChatBotService
import com.afoxplus.data.source.network.user.service.IUserService
import retrofit2.Retrofit

fun providerChatBotService(retrofit: Retrofit): IChatBotService =
    retrofit.create(IChatBotService::class.java)

fun providerUserService(retrofit: Retrofit): IUserService = retrofit.create(IUserService::class.java)