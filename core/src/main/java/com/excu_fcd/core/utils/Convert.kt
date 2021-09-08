package com.excu_fcd.core.utils

import com.excu_fcd.core.data.MimeType
import com.excu_fcd.core.data.Size
import com.excu_fcd.core.data.local.LocalItem
import java.io.File
import java.nio.file.Path

fun String.asMimeType(): MimeType = MimeType(value = this)

fun Long.asSize(): Size = Size(value = this)

fun String.asLocalItem() = LocalItem(path = this)

fun File.asLocalItem() = LocalItem(file = this)

fun Path.asLocalItem() = LocalItem(path = this)