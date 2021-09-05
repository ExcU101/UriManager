package com.excu_fcd.efm.provider

import com.excu_fcd.efm.data.Item

interface Observer<S : Item> {

    fun observe(block: S.() -> S)

}