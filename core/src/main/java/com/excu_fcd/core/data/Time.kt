package com.excu_fcd.core.data

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class Time(private val path: String) {

    private val file = File(path)

    fun getLastModifiedTimeConverted(): String {
        val date = Date(getLastModifiedTime())

        return SimpleDateFormat("dd/MM/yy").format(date)
    }

    fun getLastModifiedTime() = file.lastModified()

}