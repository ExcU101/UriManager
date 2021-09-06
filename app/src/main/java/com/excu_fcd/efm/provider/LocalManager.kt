package com.excu_fcd.efm.provider

import android.content.Context
import android.net.Uri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.request.ExecuteResult
import com.excu_fcd.efm.data.request.LocalRequest
import com.excu_fcd.efm.dsl.local
import com.excu_fcd.efm.dsl.localRequest
import com.excu_fcd.efm.provider.executor.local.LocalDeleter
import com.excu_fcd.efm.utils.logIt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LocalManager(private val context: Context) : Manager<LocalUri, LocalRequest>,
    Observer<LocalUri> {

    private val scope = CoroutineScope(IO)

    private val executors = arrayListOf(
        LocalDeleter()
    )

    fun generateLocalRequest(list: List<LocalUri>): LocalRequest {
        return localRequest {
            list {
                list.forEach {
                    add(it)
                }
            }
        }
    }

    fun generateAndPushLocalRequest(list: List<LocalUri>): ExecuteResult {
        return makeRequest(localRequest {
            list {
                list.forEach {
                    add(it)
                }
            }
        })
    }

    fun makeRequest(request: LocalRequest): ExecuteResult {
        var result = ExecuteResult.SUCCESS

        localRequest {
            name = ""
            list {
                local {
                    mustBeDirectory = true
                    uri = Uri.parse("")
                }
                local {
                    mustBeDirectory = true
                }
                local {
                    mustBeDirectory = true
                }
            }
        }
        scope.launch {
            executors.forEach {
                result = it.execute(request)
                result.reason.logIt()
            }
        }
        return result
    }

    override fun observe(block: LocalUri.() -> LocalUri) {

    }

    override fun compileRequest(request: LocalRequest) {
        request.getList().forEach {
            it.getName().logIt()
        }
    }

}