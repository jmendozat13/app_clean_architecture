package com.afoxplus.appdemo.di

import com.afoxplus.appdemo.ui.account.UserViewModel
import com.afoxplus.appdemo.ui.chat.ChatBotViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChatBotViewModel() }
    viewModel { UserViewModel() }
}