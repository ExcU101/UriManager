package com.excu_fcd.efm.utils

import android.util.Log

fun <T : Any> T.logIt(): T {
    Log.i("Loggable", this.toString())
    return this
}