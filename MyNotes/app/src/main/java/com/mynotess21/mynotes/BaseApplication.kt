package com.mynotess21.mynotes

import android.app.Application
import com.mynotess21.mynotes.di.databaseModule
import com.mynotess21.mynotes.di.localDataModule
import com.mynotess21.mynotes.di.networkModule
import com.mynotess21.mynotes.di.serviceModule
import com.mynotess21.mynotes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@BaseApplication)
            modules(networkModule,
            localDataModule,
            serviceModule,
            databaseModule,
            viewModelModule)
        }

    }
}