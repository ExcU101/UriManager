package com.excu_fcd.efm.provider.executor.local

import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.ExecuteResult
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.dsl.success
import com.excu_fcd.efm.provider.executor.Executable
import com.excu_fcd.efm.utils.logIt
import java.io.File

class LocalDeleter : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest): ExecuteResult {
        val list = request.getList()
        val last = list.last()

        list.forEach {
            val file = it.getFile()

            if (file.deleteIfExists()) {
                if (last == it) {
                    return success {
                        reason = ""
                    }
                    return ExecuteResult.SUCCESS.apply {
                        reason = ""
                    }
                }
            }
            "Some gone wrong".logIt()
        }
        return ExecuteResult.FAILURE.apply {
            reason = "Something strange (${executorClassName()})"
        }
    }

    private fun File.deleteIfExists(): Boolean {
        return if (exists()) {
            deleteRecursively()
        } else {
            "File ($name) don`t exist"
            false
        }
    }

}