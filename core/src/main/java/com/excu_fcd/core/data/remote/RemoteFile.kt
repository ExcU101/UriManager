package com.excu_fcd.core.data.remote

import android.net.Uri
import com.excu_fcd.core.data.FileItem
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class RemoteFile(private val uri: Uri) : FileItem(uri = uri) {

    override fun getId(): Int {
        return UUID.randomUUID().mostSignificantBits.toInt()
    }

}