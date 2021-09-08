package com.excu_fcd.core.data

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class MimeType(private val value: String) : Parcelable {

    @IgnoredOnParcel
    private val supportableExtensions = listOf(
        ".java",
        ".kt"
    )

    fun getExtension(): String {
        if (value.contains(".")) {
            return value.substring(value.lastIndexOf("."))
        }
        return value
    }

    fun canBeSupportable(): Boolean = supportableExtensions.contains(getExtension())

}