package com.afoxplus.data.source.local.database.di

import com.afoxplus.data.source.local.database.config.AppDemoDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    factory { AppDemoDataBase.getDatabase(androidContext(), "${androidContext().packageName}.db") }
    factory { get<AppDemoDataBase>().messageDao }
}