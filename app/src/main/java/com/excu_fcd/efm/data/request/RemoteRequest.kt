package com.excu_fcd.efm.data.request

import com.excu_fcd.efm.data.remote.RemoteUri

class RemoteRequest(private val remoteName: String, private val uris: ArrayList<RemoteUri>) :
    Request<RemoteUri>(name = remoteName) {

    open class Builder(override var name: String = "Empty request") : Request.Builder<RemoteUri>() {

        override fun build(): RemoteRequest =
            RemoteRequest(remoteName = name, uris = getList())

    }

}