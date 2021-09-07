package com.excu_fcd.core.dsl

import com.excu_fcd.core.data.request.ExecuteResult

@DslMarker
annotation class ExecuteResultMarker

inline fun success(block: ExecuteResult.() -> Unit): ExecuteResult =
    ExecuteResult.SUCCESS.apply(block)

inline fun failure(block: ExecuteResult.() -> Unit): ExecuteResult =
    ExecuteResult.FAILURE.apply(block)