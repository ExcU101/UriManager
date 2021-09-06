package com.excu_fcd.efm.provider.executor

import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.request.Request

interface Executable<U : MetaUri, R : Request<U>> {

    suspend fun execute(request: R): Boolean

}