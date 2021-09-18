package com.excu_fcd.core.extension

import androidx.core.net.toUri
import com.excu_fcd.core.data.local.LocalFile
import java.io.File

fun String.asFile(): File = File(this)

fun File.asLocalFile(): LocalFile = LocalFile(toUri())