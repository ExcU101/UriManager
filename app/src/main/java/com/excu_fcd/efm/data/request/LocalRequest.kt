package com.excu_fcd.efm.data.request

import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.dsl.RequestDslMarker
import kotlinx.parcelize.Parcelize

@Parcelize
class LocalRequest(private val localName: String, private val uris: ArrayList<LocalUri>) :
    Request<LocalUri>(name = localName) {

    override fun getList(): ArrayList<LocalUri> = uris

    @RequestDslMarker
    class Builder(override var name: String = "Empty request") :
        Request.Builder<LocalUri>(name = name) {

        override fun build(): LocalRequest = LocalRequest(name, uris = getList())

    }

}