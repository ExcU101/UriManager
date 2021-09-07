package com.excu_fcd.core.provider.executor.local

import com.excu_fcd.core.data.local.LocalUri
import com.excu_fcd.core.data.request.ExecuteResult
import com.excu_fcd.core.data.request.LocalRequest
import com.excu_fcd.core.dsl.failure
import com.excu_fcd.core.provider.executor.Executable
import com.excu_fcd.efm.utils.emptyReason

class LocalCreator : Executable<LocalUri, LocalRequest> {

    override suspend fun execute(request: LocalRequest): ExecuteResult {
        return failure {
            reason = emptyReason
        }
    }

}