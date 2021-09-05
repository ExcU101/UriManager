package com.excu_fcd.efm.data

import android.net.Uri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.remote.RemoteUri
import com.excu_fcd.efm.dsl.RequestDslMarker
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
open class MetaUri(private val uri: Uri = Uri.parse("")) : Item {

    @IgnoredOnParcel
    private val path = uri.path ?: ""

    @IgnoredOnParcel
    private val name = when {
        path.isNotEmpty() && path.contains(".") -> path.substring(path.lastIndexOf("."))
        else -> path
    }

    override fun getId(): Int {
        return path.count()
    }

    override fun getName(): String {
        return name
    }

    fun getType(): MetaUri {
        return when (uri.scheme) {
            "ftp" -> RemoteUri(uri)

            "file" -> LocalUri(uri)

            else -> this
        }
    }

    open class Builder(open var uri: Uri = Uri.parse("")) {

        open fun build(): MetaUri = MetaUri(uri = uri)

    }

}