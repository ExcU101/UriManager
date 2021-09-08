package com.excu_fcd.core.data

@JvmInline
value class Size(val value: Long) {

    companion object {
        val EMPTY: Size = Size(0L)
    }

}