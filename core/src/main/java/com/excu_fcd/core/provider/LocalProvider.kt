package com.excu_fcd.core.provider

import android.content.Context
import com.excu_fcd.core.data.local.LocalItem
import com.excu_fcd.core.utils.sdcard
import java.io.File

open class LocalProvider (private val context: Context) : Provider,
    ISubscribe {

    fun provideSdcardList(): List<LocalItem> {
        return sdcard.listFiles()!!.map {
            LocalItem(file = it)
        }
    }

    private val notificationProvider: NotificationProvider = NotificationProvider(context = context)

    override fun subscribe(subscriber: Subscriber) {
        notificationProvider.pullNewSubscriber(subscriber = subscriber)
    }

    override fun unsubscribe(subscriber: Subscriber) {

    }

    fun navigateNextPath(currentPath: String, fullPath: String): String {
        if (fullPath.contains(currentPath)) {
            val newPath = fullPath.substring(0, currentPath.lastIndex)
            return currentPath + newPath
        }
        return fullPath
    }

}