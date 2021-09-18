package com.excu_fcd.core.observer

interface Subscriber<T> {

    fun subscribeOn(item: Observer<T>)

    fun unsubscribeOn(item: Observer<T>)

}