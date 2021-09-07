package com.excu_fcd.core.utils

import android.os.Environment
import androidx.core.os.EnvironmentCompat
import java.io.File

val sdcard: File = Environment.getExternalStorageDirectory()

val musicDir = File(sdcard.path + File.pathSeparator + Environment.DIRECTORY_MUSIC)

val downloadDir: File = File(sdcard.path + File.separator + Environment.DIRECTORY_DOWNLOADS)

val isMounded: Boolean = EnvironmentCompat.getStorageState(sdcard) == Environment.MEDIA_MOUNTED

