package com.excu_fcd.core.dsl

import com.excu_fcd.core.data.MetaUri
import com.excu_fcd.core.data.local.LocalUri
import com.excu_fcd.core.data.remote.RemoteUri
import com.excu_fcd.core.data.request.LocalRequest
import com.excu_fcd.core.data.request.RemoteRequest
import com.excu_fcd.core.data.request.Request

inline fun ArrayList<LocalUri>.local(block: LocalUri.Builder.() -> Unit) {
    add(LocalUri.Builder().apply(block).build())
}

inline fun ArrayList<LocalUri>.locals(block: List<LocalUri>.() -> Unit) {
    addAll(listOf<LocalUri>().apply(block))
}

inline fun ArrayList<RemoteUri>.remote(block: RemoteUri.Builder.() -> Unit) {
    add(RemoteUri.Builder().apply(block).build())
}

inline fun ArrayList<RemoteUri>.remotes(block: List<RemoteUri>.() -> Unit) {
    addAll(listOf<RemoteUri>().apply(block))
}

inline fun ArrayList<MetaUri>.meta(block: MetaUri.Builder.() -> Unit) {
    add(MetaUri.Builder().apply(block).build())
}

inline fun ArrayList<MetaUri>.metas(block: List<MetaUri>.() -> Unit) {
    addAll(listOf<MetaUri>().apply(block))
}

inline fun <U : MetaUri> request(block: Request.Builder<U>.() -> Unit): Request<U> =
    Request.Builder<U>().apply(block = block).build()

inline fun localRequest(block: LocalRequest.Builder.() -> Unit): LocalRequest =
    LocalRequest.Builder().apply(block).build()

inline fun remoteRequest(block: RemoteRequest.Builder.() -> Unit): RemoteRequest =
    RemoteRequest.Builder().apply(block).build()

inline fun meta(block: MetaUri.Builder.() -> Unit): MetaUri =
    MetaUri.Builder().apply(block).build()

inline fun local(block: LocalUri.Builder.() -> Unit): LocalUri =
    LocalUri.Builder().apply(block).build()

inline fun remote(block: RemoteUri.Builder.() -> Unit): RemoteUri =
    RemoteUri.Builder().apply(block).build()

