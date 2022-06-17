package com.example.weatherapp

import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import org.jetbrains.annotations.NotNull
import timber.log.Timber


class ReleaseTree : @NotNull Timber.Tree() {
    var crashlytics = Firebase.crashlytics
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            // send the error reports to crashlytics
//            crashlytics.setUserId("SK")
//            crashlytics.log("My custom log message")
            crashlytics.log("$priority, $tag, $message")
            t?.let { crashlytics.recordException(it) }


        }

    }
}

