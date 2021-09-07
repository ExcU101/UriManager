package com.excu_fcd.core.utils

import android.content.ClipboardManager
import android.content.Context
import android.net.wifi.WifiManager
import android.os.storage.StorageManager
import androidx.core.app.NotificationManagerCompat

fun Context.getClipboardManager(): ClipboardManager =
    getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

fun Context.getWifiManager(): WifiManager =
    applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

fun Context.getNotificationManager(): NotificationManagerCompat =
    NotificationManagerCompat.from(this)

fun Context.getStorageManager(): StorageManager =
    getSystemService(Context.STORAGE_SERVICE) as StorageManager