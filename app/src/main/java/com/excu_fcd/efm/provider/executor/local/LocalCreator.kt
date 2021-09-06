package com.excu_fcd.efm.provider.executor.local

import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.ExecuteResult
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.dsl.failure
import com.excu_fcd.efm.provider.executor.Executable
import com.excu_fcd.efm.utils.emptyReason

class LocalCreator : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest): ExecuteResult {
        return failure {
            reason = emptyReason
        }
    }

}