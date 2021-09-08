package com.excu_fcd.core.data.local

import com.excu_fcd.core.data.Item
import com.excu_fcd.core.data.MimeType
import com.excu_fcd.core.data.Size
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.io.File
import java.nio.file.Path

@Parcelize
class LocalItem(private val path: String) : Item {

    @IgnoredOnParcel
    private val mimeType = MimeType(path)

    constructor(path: Path) : this(path = path.toString())

    constructor(file: File) : this(path = file.path)

    fun getMimeType(): MimeType = mimeType

    fun getSize(): Size {
        return Size.EMPTY
    }

    override fun getName(): String {
        if (path.contains("/")) {
            return path.substring(path.lastIndexOf("/"))
        }
        return path
    }

    override fun compareTo(other: Item): Int {
        return other.getId() - this.getId()
    }

}