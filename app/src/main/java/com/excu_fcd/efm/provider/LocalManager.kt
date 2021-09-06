package com.excu_fcd.efm.provider

import android.content.Context
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.provider.executor.local.LocalDeleter
import com.excu_fcd.efm.utils.logIt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LocalManager(private val context: Context) : Manager<LocalUri, LocalRequest>,
    Observer<LocalUri> {

    private val executors = arrayListOf(
        LocalDeleter()
    )

    suspend fun makeRequest(request: LocalRequest) = CoroutineScope(IO).launch {
        executors.forEach {
            it.execute(request)
        }
    }

    override fun observe(block: LocalUri.() -> LocalUri) {

    }

    override fun compileRequest(request: LocalRequest) {
        request.getList().forEach {
            it.getName().logIt()
        }
    }

}