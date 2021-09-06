package com.excu_fcd.efm.data.request

import android.os.Parcelable
import com.excu_fcd.efm.dsl.ExecuteResultMarker
import com.excu_fcd.efm.utils.emptyReason
import kotlinx.parcelize.Parcelize

@ExecuteResultMarker
@Parcelize
enum class ExecuteResult(var reason: String = emptyReason) : Parcelable {
    SUCCESS(reason = ""),
    FAILURE,
}