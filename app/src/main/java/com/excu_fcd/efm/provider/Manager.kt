package com.excu_fcd.efm.provider

import com.excu_fcd.efm.data.request.Request

interface Manager {

    fun compileRequest(request: Request)

}