package com.dnd.sixth.lmsservice

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.dnd.sixth.lmsservice.di.modules.mainViewModelModule
import com.dnd.sixth.lmsservice.di.modules.makeClassModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                listOf(
                    mainViewModelModule,
                    makeClassModelModule
                )
            )

        }
    }

    override fun onTerminate() {
        super.onTerminate()
        context = null
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
            private set
    }

}
