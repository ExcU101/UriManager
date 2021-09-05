package com.excu_fcd.efm.data.request

import android.os.Parcelable
import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.dsl.RequestDslMarker
import kotlinx.parcelize.Parcelize

@Parcelize
class Request(
    private val name: String = "Empty request",
    private val uris: ArrayList<MetaUri> = arrayListOf()
) :
    Parcelable {

    fun getName(): String = name

    fun getUris(): ArrayList<MetaUri> = uris

    @RequestDslMarker
    class Builder(
        var name: String = "Empty request",
    ) {
        private val uris = arrayListOf<MetaUri>()

        fun list(block: ArrayList<MetaUri>.() -> Unit) {
            uris.addAll(ArrayList<MetaUri>().apply(block))
        }

        fun build(): Request = Request(name = name, uris = uris)
    }

}