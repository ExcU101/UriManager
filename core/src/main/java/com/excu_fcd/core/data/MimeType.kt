package com.excu_fcd.core.data

interface MimeType {

    fun getMimeType() = this

    fun getExtension(): String

    fun canBeSupportable(): Boolean

}