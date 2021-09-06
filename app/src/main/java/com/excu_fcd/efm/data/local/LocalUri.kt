package com.excu_fcd.efm.data.local

import android.net.Uri
import androidx.core.net.toFile
import com.excu_fcd.efm.data.MetaUri
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
class LocalUri(private val uri: Uri, private val mustBeDirectory: Boolean = false) :
    MetaUri(uri = uri) {

    @IgnoredOnParcel
    private val file = uri.toFile()

    fun createPath(vararg segments: String) {
        var path = "" + File.pathSeparator
        segments.forEach {
            path += File.pathSeparator + it
        }
    }

    fun createPath(pathSegments: Collection<String>) {
        var path = "" + File.pathSeparator
        pathSegments.forEach {
            path = path + File.pathSeparator + it
        }
    }

    fun getFile(): File = file

    fun getExtension(): String = file.extension

    fun getNameWithoutExtension(): String = file.nameWithoutExtension

    class Builder(override var uri: Uri = Uri.parse(""), var mustBeDirectory: Boolean = false) : MetaUri.Builder(uri = uri) {
        override fun build(): LocalUri = LocalUri(uri = uri, mustBeDirectory)
    }


}