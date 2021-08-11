package com.tfandkusu.tryphotoview

import android.app.Application
import timber.log.Timber

class TryPhotoViewApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
