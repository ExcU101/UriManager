package com.excu_fcd.core.provider

import com.excu_fcd.core.data.MetaUri
import com.excu_fcd.core.data.request.Request

interface Manager<U : MetaUri, R: Request<U>> {

    fun  compileRequest(request: R)

}