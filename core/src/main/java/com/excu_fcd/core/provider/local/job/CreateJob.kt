package com.excu_fcd.core.provider.local.job

import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.extension.failure
import com.excu_fcd.core.extension.logIt
import com.excu_fcd.core.extension.success
import com.excu_fcd.core.provider.JobProvider


class CreateJob<T> : JobProvider<LocalFile, T> {

    companion object {
        fun getTag(): String {
            return "CREATE"
        }
    }

    override fun getName(): String {
        return "Create job provider"
    }

    override suspend fun providerJob(
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val operation = request.getOperation()
        val items = request.getItems()
        val metas = operation.getMetas() as MutableList<String>
        val isNeedToCreateDirectory = metas.contains("FOLDER")

        if (operation.getTag() != getTag() || !getTag().contains(operation.getTag())) {
            return
        }
        request.setStatus(Request.Status.RUNNING)
        request.notifyObservers()

        items.forEach {
            if (isNeedToCreateDirectory.logIt()) {
                createDirectory(localFile = it, request = request, onResponse = onResponse)
            } else {
                createFile(localFile = it, request = request, onResponse = onResponse)
            }
            request.notifyObservers()
        }
    }

    private fun createFile(
        localFile: LocalFile,
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val file = localFile.getFile()
        if (!file.exists()) {
            if (file.createNewFile()) {
                request.updateProgress(1)
                onResponse(success(localFile))
            } else {
                onResponse(failure(localFile, reason = "Something gone wrong"))
            }
        } else {
            onResponse(failure(localFile, reason = "File already exist"))
        }
    }

    private fun createDirectory(
        localFile: LocalFile,
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        val directory = localFile.getFile()
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                request.updateProgress(1)
                onResponse(success(localFile))
            } else {
                onResponse(failure(localFile, reason = "Something gone wrong"))
            }
        } else {
            onResponse(failure(localFile, reason = "Directory already exist"))
        }
    }

}