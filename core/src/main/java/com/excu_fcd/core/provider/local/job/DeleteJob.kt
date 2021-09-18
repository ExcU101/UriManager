package com.excu_fcd.core.provider.local.job

import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.extension.failure
import com.excu_fcd.core.extension.success
import com.excu_fcd.core.provider.JobProvider

class DeleteJob<T> : JobProvider<LocalFile, T> {

    companion object {
        fun getTag() = "DELETE"
    }

    override fun getName(): String {
        return "Delete job provider"
    }

    override suspend fun providerJob(
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val operation = request.getOperation()
        val items = request.getItems()

        if (operation.getTag() != getTag() || !getTag().contains("DELETE")) {
            return
        }

        items.forEach {
            delete(localFile = it, request = request, onResponse = onResponse)
        }
    }

    private fun delete(
        localFile: LocalFile,
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val file = localFile.getFile()

        if (file.exists()) {
            if (file.deleteRecursively()) {
                request.updateProgress(1)
                onResponse(success(item = localFile))
            } else {
                onResponse(failure(item = localFile, reason = "Something gone wrong"))
            }
        } else {
            onResponse(failure(item = localFile, reason = "Don't exist"))
        }
    }

}