package com.excu_fcd.efm.dsl

import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.remote.RemoteUri
import com.excu_fcd.efm.data.request.Request

fun ArrayList<MetaUri>.item(block: MetaUri.Builder.() -> Unit) {
    add(MetaUri.Builder().apply(block).build())
}

fun ArrayList<MetaUri>.items(block: List<MetaUri>.() -> Unit) {
    addAll(listOf<MetaUri>().apply(block))
}

fun request(block: Request.Builder.() -> Unit): Request =
    Request.Builder().apply(block = block).build()

fun metaUri(block: MetaUri.Builder.() -> Unit): MetaUri =
    MetaUri.Builder().apply(block).build()

fun localUri(block: LocalUri.Builder.() -> Unit): LocalUri =
    LocalUri.Builder().apply(block).build()

fun remoteUri(block: RemoteUri.Builder.() -> Unit): RemoteUri =
    RemoteUri.Builder().apply(block).build()

