package com.excu_fcd.efm.data.request

import android.os.Parcelable
import com.excu_fcd.efm.utils.emptyReason
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ExecuteResult(val reason: String = emptyReason) : Parcelable {
    SUCCESS,
    FAILURE,
}