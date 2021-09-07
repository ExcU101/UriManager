package com.excu_fcd.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MimeType(private val value: String) : Parcelable {

    fun getExtension(): String {
        if (value.contains(".")) {
            return value.substring(value.lastIndexOf("."))
        }
        return value
    }

}