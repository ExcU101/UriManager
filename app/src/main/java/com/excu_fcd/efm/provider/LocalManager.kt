package com.excu_fcd.efm.provider

import android.content.Context
import android.net.Uri
import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.Request
import com.excu_fcd.efm.dsl.request
import com.excu_fcd.efm.utils.logIt

class LocalManager(private val context: Context) : Manager, Observer<LocalUri> {

    override fun observe(block: LocalUri.() -> LocalUri) {

    }

    override fun compileRequest(request: Request) {
        request.getUris().forEach {
            it.getName().logIt()
        }
    }

}