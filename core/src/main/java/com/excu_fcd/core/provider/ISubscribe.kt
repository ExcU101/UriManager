package com.excu_fcd.core.provider

interface ISubscribe {

    fun subscribe(subscriber: Subscriber)

    fun unsubscribe(subscriber: Subscriber)

}