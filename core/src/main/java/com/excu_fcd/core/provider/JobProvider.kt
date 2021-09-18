package com.excu_fcd.core.provider

import com.excu_fcd.core.data.request.Request

interface JobProvider<F, T> {

    fun getName(): String

    suspend fun providerJob(request: Request<F, T>, onResponse: (result: String) -> Unit)

    class Result(val description: String, val isCompleted: Boolean)

}