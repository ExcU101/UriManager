package com.excu_fcd.core.provider.local

import android.os.Environment
import androidx.core.net.toUri
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.provider.FileProvider
import com.excu_fcd.core.provider.JobProvider
import com.excu_fcd.core.provider.local.job.CopyJob
import com.excu_fcd.core.provider.local.job.CreateJob
import com.excu_fcd.core.provider.local.job.DeleteJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LocalProvider<T> : FileProvider<LocalFile, T>() {

    private val jobProviders = arrayListOf<JobProvider<LocalFile, T>>(
        CreateJob(),
        DeleteJob(),
        CopyJob()
    )

    fun provideSdcardList() =
        Environment.getExternalStorageDirectory().listFiles().map { LocalFile(it.toUri()) }

    fun suspendedMakeRequest(request: Request<LocalFile, T>, onResponse: (result: String) -> Unit) {
        CoroutineScope(IO).launch {
            makeRequest(request = request, onResponse = onResponse)
        }
    }

    override suspend fun makeRequest(
        request: Request<LocalFile, T>,
        onResponse: (result: String) -> Unit,
    ) {
        jobProviders.forEach {
            it.providerJob(request = request, onResponse = onResponse)
        }
    }

}