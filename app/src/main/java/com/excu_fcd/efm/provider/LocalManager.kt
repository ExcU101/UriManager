package com.excu_fcd.efm.provider

import android.content.Context
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.LocalRequest

class LocalManager(private val context: Context) : Manager<LocalUri, LocalRequest>,
    Observer<LocalUri> {

    fun makeRequest() {

    }

    override fun observe(block: LocalUri.() -> LocalUri) {

    }

    override fun compileRequest(request: LocalRequest) {

    }

}