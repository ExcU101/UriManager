package com.excu_fcd.core.utils

import android.net.Uri
import com.excu_fcd.core.data.MetaUri
import com.excu_fcd.core.data.local.LocalUri
import com.excu_fcd.core.data.remote.RemoteUri

fun Uri.toLocalUri(): LocalUri = LocalUri(uri = this)

fun Uri.toRemoteUri(): RemoteUri = RemoteUri(uri = this)

fun Uri.toMetaUri(): MetaUri = MetaUri(uri = this)
