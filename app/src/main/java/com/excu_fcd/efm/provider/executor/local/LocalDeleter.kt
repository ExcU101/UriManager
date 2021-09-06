package com.excu_fcd.efm.provider.executor.local

import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.provider.executor.Executable

class LocalDeleter : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest) {
        request.getList().forEach {

        }
    }

}