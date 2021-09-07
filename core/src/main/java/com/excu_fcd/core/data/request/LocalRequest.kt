package com.excu_fcd.core.data.request

import com.excu_fcd.core.data.local.LocalUri
import com.excu_fcd.core.dsl.RequestDslMarker
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