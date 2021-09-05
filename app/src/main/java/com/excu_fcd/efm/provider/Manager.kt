package com.excu_fcd.efm.provider

import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.request.Request

interface Manager<U : MetaUri, R: Request<U>> {

    fun  compileRequest(request: R)

}