package com.afoxplus.appdemo

import android.app.Application
import com.afoxplus.data.di.repositoryModule
import com.afoxplus.data.source.di.dataSourceModule
import com.afoxplus.data.source.local.database.di.dataBaseModule
import com.afoxplus.data.source.network.di.BASE_URL
import com.afoxplus.data.source.network.di.networkModule
import com.afoxplus.data.source.network.di.retrofitModule
import com.afoxplus.domain.di.useCaseModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationBase : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ApplicationBase)
            modules(
                listOf(
                    retrofitModule,
                    dataBaseModule,
                    networkModule,
                    dataSourceModule,
                    repositoryModule,
                    useCaseModule
                )
            )

        }

        getKoin().run {
            setProperty(BASE_URL, BuildConfig.BASE_URL)
        }
    }
}