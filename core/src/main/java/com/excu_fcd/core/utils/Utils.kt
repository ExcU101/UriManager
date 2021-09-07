package com.excu_fcd.core.utils

import android.util.Log

fun <T : Any> T.logIt(): T {
    Log.i("Loggable (${this::class.simpleName})", this.toString())
    return this
}

const val emptyReason = "Empty reason"