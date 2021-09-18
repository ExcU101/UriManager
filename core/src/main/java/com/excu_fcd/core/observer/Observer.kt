package com.excu_fcd.core.observer

interface Observer<T> {

    fun getName(): String

    fun onSubscribed(item: T)

    fun onSubscription(item: T)

}