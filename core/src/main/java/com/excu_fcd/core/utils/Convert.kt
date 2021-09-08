package com.excu_fcd.core.utils

import com.excu_fcd.core.data.MimeType
import com.excu_fcd.core.data.Size

fun String.asMimeType(): MimeType = MimeType(this)

fun Long.asSize(): Size = Size(this)
