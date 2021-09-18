package com.excu_fcd.core.data

import android.os.Parcelable

interface Item : Parcelable, Comparable<Item> {

    fun getId(): Int

    fun getName(): String

    override fun compareTo(other: Item): Int {
        return this.getId() - other.getId()
    }

}