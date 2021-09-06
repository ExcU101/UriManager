package com.excu_fcd.efm.provider.executor.local

import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.provider.executor.Executable
import com.excu_fcd.efm.utils.logIt
import java.io.File

class LocalDeleter : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest): Boolean {
        val list = request.getList()
        val last = list.last()

        list.forEach {
            val file = it.getFile()

            if (file.deleteIfExists()) {
                if (last == it) {
                    return true
                }
            }
            "Some gone wrong".logIt()
        }
        return false
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