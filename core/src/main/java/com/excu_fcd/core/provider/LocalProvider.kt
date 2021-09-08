package com.excu_fcd.core.provider

import android.content.Context

class LocalProvider(private val context: Context) : Provider,
    ISubscribe {

    private val notificationProvider: NotificationProvider = NotificationProvider(context = context)

    override fun subscribe(subscriber: Subscriber) {
        notificationProvider.pullNewSubscriber(subscriber = subscriber)
    }

    override fun unsubscribe(subscriber: Subscriber) {

    }

}