package com.excu_fcd.core.provider.local.job

import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.extension.failure
import com.excu_fcd.core.extension.logIt
import com.excu_fcd.core.extension.notThatTag
import com.excu_fcd.core.extension.success
import com.excu_fcd.core.provider.JobProvider

class CopyJob<T> : JobProvider<LocalFile, T> {

    companion object {
        fun getTag() = "COPY"
    }

    override fun getName(): String {
        return "Copy job provider"
    }

    override suspend fun providerJob(
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val operation = request.getOperation()
        val items = request.getItems()

        if (operation.getTag() != getTag() || !getTag().contains("COPY")) {
            notThatTag(request = request).logIt()
            return
        } else if (items.isEmpty() || items.size < 2) {
            return
        }

        val last = items.last()

        items.forEach {
            if (it != last) {
                copy(src = it, target = last, onResponse = onResponse)
            }
        }
    }

    private fun copy(src: LocalFile, target: LocalFile, onResponse: (result: String) -> Unit) {
        val fSrc = src.getFile()
        val fTarget = target.getFile()

        if (fSrc.exists().logIt()) {
            if (fTarget.exists().logIt()) {
                if (fSrc.isDirectory) {
                    if (fSrc.copyRecursively(target = fTarget, overwrite = true)) {
                        onResponse(success(src, reason = "Copied to ${target.getName()}"))
                    } else {
                        onResponse(failure(target, reason = "Something gone wrong"))
                    }
                } else {
                    if (fSrc.copyTo(target = fTarget, overwrite = true).delete()) {
                        onResponse(success(src, reason = "Copied to ${target.getName()}"))
                    } else {
                        onResponse(failure(target, reason = "Something gone wrong"))
                    }
                }

            } else {
                onResponse(failure(target, reason = "Don't exits"))
            }
        } else {
            onResponse(failure(src, reason = "Don't exits"))
        }
    }

}