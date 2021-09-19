package com.excu_fcd.core.dsl

import android.net.Uri
import android.os.Environment
import androidx.core.net.toUri
import com.excu_fcd.core.data.Item
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.remote.RemoteFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.provider.local.job.CopyJob
import com.excu_fcd.core.provider.local.job.CreateJob
import com.excu_fcd.core.provider.local.job.DeleteJob

@DslMarker
annotation class RequestBuilderMarker

private val tags = listOf(
    CreateJob.getTag(),
    DeleteJob.getTag(),
    CopyJob.getTag(),
)

fun tag(index: Int) = tags[index]

fun MutableList<LocalFile>.localItem(path: String = "Empty path") {
    add(LocalFile(uri = path.toUri()))
}

fun MutableList<LocalFile>.localItem(uri: Uri = Environment.getRootDirectory().toUri()) {
    add(LocalFile(uri = uri))
}

fun MutableList<RemoteFile>.remoteItem(path: String = "Empty path") {
    add(RemoteFile(uri = path.toUri()))
}

fun MutableList<RemoteFile>.remoteItem(uri: Uri = Uri.EMPTY) {
    add(RemoteFile(uri = uri))
}

fun <T> MutableList<T>.item(data: T) {
    add(data)
}

inline fun <F : Item, T> builder(block: Request.Builder<F, T>.() -> Unit) =
    Request.Builder<F, T>().apply(block)

inline fun <F : Item, T> singletonRequestBuilder(block: Request.Builder<F, T>.() -> Unit) =
    Request.Builder<F, T>().apply(block).singleton()

inline fun <F : Item, T> request(block: Request.Builder<F, T>.() -> Unit) =
    Request.Builder<F, T>().apply(block).build()