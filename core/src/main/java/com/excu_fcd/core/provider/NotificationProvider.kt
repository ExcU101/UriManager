package com.excu_fcd.core.provider

import android.app.Notification
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.excu_fcd.core.utils.getNotificationManager

class NotificationProvider(private val context: Context) {

    private val manager: NotificationManagerCompat = context.getNotificationManager()

    companion object {
        const val ID_LOCAL = "0"
        const val ID_REMOTE = "1"
    }

    fun createNotification(@DrawableRes icon: Int, title: String, content: String): Notification {
        return builder(ID_LOCAL).setSmallIcon(icon).setContentTitle(title).setContentText(content)
            .build()
    }

    fun getManager(): NotificationManagerCompat = manager

    private fun builder(id: String): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, id)
    }

}