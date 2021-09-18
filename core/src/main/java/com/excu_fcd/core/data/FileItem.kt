package com.excu_fcd.core.data

import android.net.Uri
import kotlinx.parcelize.IgnoredOnParcel

abstract class FileItem(private val uri: Uri) : Item, MimeType, Size {

    @IgnoredOnParcel
    private var path: String = uri.path ?: "Null path"

    private var name = if (path.contains("/")) {
        path.substring(path.lastIndexOf("/") + 1)
    } else {

        path.trim()
    }


    override fun getMimeType(): MimeType = this

    fun getPort() = uri.port

    fun getAuthority() = uri.authority.toString()

    fun getPath(): String = path

    fun setPath(path: String) {
        this.path = path
    }

    fun setName(name: String) {
        this.name = name
    }

    override fun getName(): String = name

}