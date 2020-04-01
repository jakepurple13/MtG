package com.programmersbox.mtg

import android.app.Application
import com.programmersbox.loggingutils.Loged

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Loged.FILTER_BY_PACKAGE_NAME = "programmersbox"
        Loged.TAG = "MagicGather"
    }
}