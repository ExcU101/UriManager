package com.excu_fcd.core.data

@JvmInline
value class Size(val value: Long) {

    companion object {
        val EMPTY: Size = Size(0L)
    }

    fun convertToNamedSize(): String {
        var index = 0
        var mValue = value

        while (mValue > 1024) {
            mValue /= 1024
            index++
        }

        return when (index) {
            1 -> "$mValue KB"

            2 -> "$mValue MB"

            3 -> "$mValue GB"

            4 -> "$mValue TB"

            else -> "$mValue B"
        }

    }

}