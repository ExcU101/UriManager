package com.excu_fcd.efm.data.remote

import android.net.Uri
import com.excu_fcd.efm.data.MetaUri
import kotlinx.parcelize.Parcelize

@Parcelize
class RemoteUri(private val uri: Uri) : MetaUri(uri = uri) {

    class Builder(override var uri: Uri = Uri.parse("")) : MetaUri.Builder(uri = uri) {
        override fun build(): RemoteUri = RemoteUri(uri = uri)
    }

}