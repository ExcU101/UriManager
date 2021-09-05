package com.excu_fcd.efm.data

import android.os.Parcelable

interface Item : Parcelable {

    fun getId(): Int

    fun getName(): String

}