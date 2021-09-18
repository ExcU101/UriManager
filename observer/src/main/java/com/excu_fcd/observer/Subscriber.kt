package com.excu_fcd.observer

interface Subscriber {

    fun getName(): String

    fun subscribe()

    fun unsubscribe()

}