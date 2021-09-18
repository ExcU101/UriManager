package com.excu_fcd.core.extension

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.excu_fcd.core.data.FileItem
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.provider.JobProvider

fun <F, T> JobProvider<F, T>.failure(item: FileItem, reason: String = "Empty reason"): String {
    return "Operation: ${getName()} \n" +
            "Result: FAILURE \n" +
            "File: ${item.getName()} \n" +
            "Path: ${item.getPath()} \n" +
            "Reason: $reason \n"
}

fun <F, T> JobProvider<F, T>.success(item: FileItem, reason: String = "Empty reason"): String {
    return "Operation: ${getName()} \n" +
            "Result: SUCCESS \n" +
            "File: ${item.getName()} \n" +
            "Path: ${item.getPath()} \n" +
            "Reason: $reason \n"
}

fun <F, T> JobProvider<F, T>.notThatTag(request: Request<F, T>): String {
    return "Not compared ${getName()} \n Request: ${request.getName()}"
}

fun <F, T> JobProvider<F, T>.logIndexedItem(index: Int, item: FileItem) {
    "Index: $index".logIt()
    "Name: ${item.getName()}".logIt()
    "Path: ${item.getPath()}".logIt()
}

fun String.toastIt(context: Context) = Toast.makeText(context, this, Toast.LENGTH_SHORT).show()

fun <F, T> JobProvider<F, T>.logItem(item: FileItem) {
    "Name: ${item.getPath()}".logIt()
    "Path: ${item.getPath()}".logIt()
}

fun <T : Any> T.logIt(): T {
    Log.i("Loggable (${javaClass.simpleName})", this.toString())
    return this
}

fun String.logIt(): String {
    Log.i("Loggable (String)", this)
    return this
}