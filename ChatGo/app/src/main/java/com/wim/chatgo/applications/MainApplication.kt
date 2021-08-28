package com.wim.chatgo.applications

import android.app.Application
import com.wim.chatgo.BuildConfig
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        configureTimber();
    }

    fun configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}