package com.excu_fcd.core.provider

interface Subscriber<A : Any> {

    fun subscribe()

    fun unsubscribe()

}