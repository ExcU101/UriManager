package com.excu_fcd.efm.utils

import android.net.Uri
import com.excu_fcd.efm.data.MetaUri
import com.excu_fcd.efm.data.local.LocalUri
import com.excu_fcd.efm.data.remote.RemoteUri

fun Uri.toLocalUri(): LocalUri = LocalUri(uri = this)

fun Uri.toRemoteUri(): RemoteUri = RemoteUri(uri = this)

fun Uri.toMetaUri(): MetaUri = MetaUri(uri = this)
