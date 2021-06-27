package com.afoxplus.appdemo

import android.app.Application
import com.afoxplus.appdemo.di.viewModelModule
import com.afoxplus.data.di.loadRepositoryModule
import com.afoxplus.data.source.network.core.di.BASE_URL
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
            loadRepositoryModule
            modules(
                listOf(
                    useCaseModule,
                    viewModelModule
                )
            )
        }

        getKoin().run {
            setProperty(BASE_URL, BuildConfig.BASE_URL)
        }
    }
}