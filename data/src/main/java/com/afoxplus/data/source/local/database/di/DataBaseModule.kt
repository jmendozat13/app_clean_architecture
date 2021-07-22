package com.afoxplus.data.source.local.database.di

import com.afoxplus.data.source.local.database.core.AppDemoDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    single { AppDemoDataBase.getDatabase(androidContext(), "${androidContext().packageName}.db") }
    single { get<AppDemoDataBase>().messageDao }
    single { get<AppDemoDataBase>().trackDao }
    single { get<AppDemoDataBase>().optionMessageDao }
    single { get<AppDemoDataBase>().userDao }
}