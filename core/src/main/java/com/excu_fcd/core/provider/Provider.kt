package com.excu_fcd.core.provider

interface Provider {

    fun getName(): String = javaClass.simpleName

}