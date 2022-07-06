package com.jarvis.forexapp

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        instance = this
    }
}