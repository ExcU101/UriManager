package com.excu_fcd.core.data

import android.os.Parcelable

interface Item : Parcelable, Comparable<Item> {

    fun getId(): Int

    fun getName(): String

}