package com.example.weatherapp.Logs

import android.app.Application
import com.example.weatherapp.BuildConfig
import timber.log.Timber

class ApplicationController : Application() {
//    companion object{
//        const val isDebugMode: Boolean = true
//    }


    override fun onCreate() {
        super.onCreate()
        if (!BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "Class:%s: Line: %s, Method: %s",
                        super.createStackElementTag(element),
                        element.lineNumber,
                        element.methodName

                    )

                }
            })
        } else {
            Timber.plant(ReleaseTree())
        }

    }
}
