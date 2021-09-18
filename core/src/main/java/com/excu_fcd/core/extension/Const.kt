package com.excu_fcd.core.extension

import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.remote.RemoteFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.data.request.Request.Operation.Companion.EMPTY_TAG
import com.excu_fcd.core.dsl.builder
import com.excu_fcd.core.observer.Observer

fun <T> simpleLocalInstance(
    tag: String = EMPTY_TAG,
    items: MutableList<LocalFile>.() -> Unit,
    metaDates: MutableList<T>.() -> Unit,
    observers: (MutableList<Observer<Request<LocalFile, T>>>.() -> Unit)? = null,
) = builder<LocalFile, T> {
    operationName(operationName = "Simple operation name")
    operationTag(operationTag = tag)
    storageType(storageType = Request.Operation.StorageType.LOCAL)
    requestName(requestName = "Simple request name")

    items(items)
    metaDates(metaDates)
    observers?.let {
        observers(it)
    }
}.build()

fun <T> simpleRemoteInstance(
    tag: String = EMPTY_TAG,
    items: MutableList<RemoteFile>.() -> Unit,
    metaDates: MutableList<T>.() -> Unit,
) = builder<RemoteFile, T> {
    operationName(operationName = "Simple operation name")
    operationTag(operationTag = tag)
    storageType(storageType = Request.Operation.StorageType.LOCAL)
    requestName(requestName = "Simple request name")

    items(items)
    metaDates(metaDates)
}.build()