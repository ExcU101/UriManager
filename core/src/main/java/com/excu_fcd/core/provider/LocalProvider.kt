package com.excu_fcd.core.provider

import android.content.Context
import android.os.Parcelable
import androidx.core.app.NotificationManagerCompat
import com.excu_fcd.core.utils.getNotificationManager
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.WriteWith

class LocalProvider(private val context: Context) : Provider,
    Subscriber<Any> {

    private val manager: NotificationManagerCompat = context.getNotificationManager()

    override fun subscribe() {

    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

}