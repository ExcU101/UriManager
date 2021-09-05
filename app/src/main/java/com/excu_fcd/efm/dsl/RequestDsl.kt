package com.excu_fcd.efm.dsl

import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.remote.RemoteUri
import com.excu_fcd.efm.data.request.Request

inline fun ArrayList<MetaUri>.item(block: MetaUri.Builder.() -> Unit) {
    add(MetaUri.Builder().apply(block).build())
}

inline fun ArrayList<MetaUri>.items(block: List<MetaUri>.() -> Unit) {
    addAll(listOf<MetaUri>().apply(block))
}

inline fun request(block: Request.Builder.() -> Unit): Request =
    Request.Builder().apply(block = block).build()

inline fun metaUri(block: MetaUri.Builder.() -> Unit): MetaUri =
    MetaUri.Builder().apply(block).build()

inline fun localUri(block: LocalUri.Builder.() -> Unit): LocalUri =
    LocalUri.Builder().apply(block).build()

inline fun remoteUri(block: RemoteUri.Builder.() -> Unit): RemoteUri =
    RemoteUri.Builder().apply(block).build()

