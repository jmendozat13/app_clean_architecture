package com.afoxplus.data.source.local.database.core.di

import com.afoxplus.data.source.local.database.core.AppDemoDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule = module {
    factory { AppDemoDataBase.getDatabase(androidContext(), "${androidContext().packageName}.db") }
    factory { get<AppDemoDataBase>().messageDao }
    factory { get<AppDemoDataBase>().trackDao }
    factory { get<AppDemoDataBase>().optionMessageDao }
}