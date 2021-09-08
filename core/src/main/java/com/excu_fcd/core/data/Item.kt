package com.excu_fcd.core.data

import android.os.Parcelable
import kotlin.random.Random

interface Item : Parcelable, Comparable<Item> {

    fun getId(): Int = Random.nextInt()

    fun getName(): String

}