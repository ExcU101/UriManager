package com.excu_fcd.core.provider.executor.local

import com.excu_fcd.core.data.local.LocalUri
import com.excu_fcd.core.data.request.ExecuteResult
import com.excu_fcd.core.data.request.LocalRequest
import com.excu_fcd.core.dsl.failure
import com.excu_fcd.core.dsl.success
import com.excu_fcd.core.provider.executor.Executable
import com.excu_fcd.efm.utils.logIt
import java.io.File

class LocalDeleter : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest): ExecuteResult {
        val list = request.getList()
        val last = list.last()

        list.forEach {
            val file = it.getFile()
            "${it.getName()} running".logIt()

            if (file.deleteIfExists()) {
                if (last == it) {
                    return success {
                        reason = "Reached and deleted last file (${executorClassName()})"
                    }
                }
            }
            "Some gone wrong".logIt()
        }
        return failure {
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