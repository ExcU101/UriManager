package com.excu_fcd.core.data.local

import android.net.Uri
import android.os.Environment
import androidx.core.net.toFile
import androidx.core.net.toUri
import com.excu_fcd.core.data.FileItem
import com.excu_fcd.core.extension.asFile
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.io.File
import java.util.*

@Parcelize
class LocalFile(private val uri: Uri = Environment.getRootDirectory().toUri()) :
    FileItem(uri = uri) {

    override fun getExtension(): String {
        return if (!isDirectory && getName().contains(".")) {
            getName().substring(getName().lastIndexOf("."))
        } else if (isDirectory) {
            ""
        } else {
            getName()
        }
    }

    override fun canBeSupportable(): Boolean = true

    override fun convertedSize(): String = "4 KB"

    @IgnoredOnParcel
    private val file = uri.toFile()

    @IgnoredOnParcel
    val isDirectory = file.isDirectory

    fun getFile(): File = file

    fun rename(name: String) {
        val target: File = getPath().substring(0, getPath().indexOf(name) - 1).asFile()
        setName(name = name)
        if (getFile().exists()) {
            if (uri.toFile().renameTo(target)) {
                setPath(target.path)
            }
        }
    }

    override fun getId(): Int {
        return UUID.randomUUID().mostSignificantBits.toInt()
    }

}