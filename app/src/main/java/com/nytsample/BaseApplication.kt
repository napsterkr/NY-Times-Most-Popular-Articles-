package com.nytsample

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    init {
        /**
         * Application Instance
         */
        baseApplicationinstance = this

    }

    companion object {
        private lateinit var baseApplicationinstance: BaseApplication
        fun applicationContext(): Context {
            return baseApplicationinstance.applicationContext
        }

        fun getInstance(): BaseApplication {
            return baseApplicationinstance
        }
    }

}