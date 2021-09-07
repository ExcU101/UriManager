package com.excu_fcd.core.provider

import com.excu_fcd.core.data.Item

interface Observer<S : Item> {

    fun observe(block: S.() -> S)

}