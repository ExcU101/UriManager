package com.excu_fcd.core.provider

import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.observer.Observer
import com.excu_fcd.core.observer.Subscriber

abstract class FileProvider<F, T> : Subscriber<Request<F, T>> {

    abstract suspend fun makeRequest(request: Request<F, T>, onResponse: (result: String) -> Unit)

    private val observers = arrayListOf<Observer<Request<F, T>>>()

    fun getObservers() = observers

    override fun subscribeOn(item: Observer<Request<F, T>>) {
        observers.add(item)
    }

    override fun unsubscribeOn(item: Observer<Request<F, T>>) {
        observers.remove(item)
    }

}