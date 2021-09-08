package com.excu_fcd.core.provider

import android.app.Notification
import android.content.Context
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.excu_fcd.core.R
import com.excu_fcd.core.utils.getNotificationManager

class NotificationProvider(private val context: Context) {

    private val manager: NotificationManagerCompat = context.getNotificationManager()

    companion object {
        const val ID_LOCAL = "0"
        const val ID_REMOTE = "1"
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel()
        }
    }

    private fun createChannel(
        name: String = "Local channel name",
        id: String = ID_LOCAL,
        description: String = "",
        importance: Int = NotificationManagerCompat.IMPORTANCE_DEFAULT,
    ) {
        val channel = NotificationChannelCompat.Builder(id, importance).setDescription(description)
            .setName(name).build()

        manager.createNotificationChannel(channel)
    }

    fun pullNewSubscriber(subscriber: Subscriber) {
        val notification = createNotification(
            icon = R.drawable.ic_add_check_24,
            title = "Subscriber ${subscriber.getName()} added!",
            content = "Subscriber added to a list of subscribers"
        )
        manager.notify(0, notification)
    }

    fun createNotification(
        @DrawableRes icon: Int,
        title: String,
        content: String,
        priority: Int = NotificationCompat.PRIORITY_DEFAULT,
        id: String = ID_LOCAL
    ): Notification {
        return builder(id).setSmallIcon(icon).setContentTitle(title).setContentText(content)
            .setPriority(priority)
            .build()
    }

    fun getManager(): NotificationManagerCompat = manager

    private fun builder(id: String): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, id)
    }

}