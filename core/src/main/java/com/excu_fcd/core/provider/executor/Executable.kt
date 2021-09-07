package com.excu_fcd.core.provider.executor

import com.excu_fcd.core.data.MetaUri
import com.excu_fcd.core.data.request.ExecuteResult
import com.excu_fcd.core.data.request.Request

interface Executable<U : MetaUri, R : Request<U>> {

    suspend fun execute(request: R): ExecuteResult

    fun executorClassName(): String? = this::class.simpleName

}