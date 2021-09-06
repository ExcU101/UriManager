package com.excu_fcd.efm.data.request

import android.os.Parcelable
import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.dsl.RequestDslMarker
import kotlinx.parcelize.Parcelize

@Parcelize
open class Request<U : MetaUri>(
    private val name: String = "Empty request",
    private val uris: ArrayList<U> = arrayListOf()
) :
    Parcelable {

    fun getName(): String = name

    open fun getList(): ArrayList<U> = uris

    @RequestDslMarker
    open class Builder<U : MetaUri>(
        open var name: String = "Empty request",
    ) {
        private val uris = arrayListOf<U>()

        internal fun getList(): ArrayList<U> = uris

        fun list(block: ArrayList<U>.() -> Unit) {
            uris.addAll(ArrayList<U>().apply(block))
        }

        open fun build(): Request<U> = Request(name = name, uris = getList())
    }

}