package com.afoxplus.appdemo

import android.app.Application
import com.afoxplus.data.di.BASE_URL
import com.afoxplus.data.di.repositoryModule
import com.afoxplus.data.di.retrofitModule
import com.afoxplus.data.source.network.di.dataSourceModule
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