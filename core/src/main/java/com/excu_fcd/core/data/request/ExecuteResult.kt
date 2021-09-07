package com.excu_fcd.core.data.request

import android.os.Parcelable
import com.excu_fcd.efm.utils.emptyReason
import kotlinx.parcelize.Parcelize


@Parcelize
enum class ExecuteResult(var reason: String = emptyReason) : Parcelable {
    SUCCESS(reason = ""),
    FAILURE,
}