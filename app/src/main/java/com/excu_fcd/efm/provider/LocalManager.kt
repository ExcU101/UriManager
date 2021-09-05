package com.excu_fcd.efm.provider

import android.content.Context
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.Request
import com.excu_fcd.efm.utils.logIt

class LocalManager(private val context: Context) : Manager, Observer<LocalUri> {

    fun makeRequest() {

    }

    override fun observe(block: LocalUri.() -> LocalUri) {

    }

    override fun compileRequest(request: Request) {
        request.getList().forEach {
            it.getName().logIt()
        }
    }

}