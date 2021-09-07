package com.excu_fcd.efm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.excu_fcd.core.dsl.local
import com.excu_fcd.core.dsl.localRequest
import com.excu_fcd.core.provider.LocalManager
import com.excu_fcd.core.provider.RemoteManager
import com.excu_fcd.core.utils.downloadDir

class MainActivity : AppCompatActivity() {

    private val localManager: LocalManager by lazy {
        LocalManager(context = this)
    }

    private val remoteManager: RemoteManager by lazy {
        RemoteManager(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        localManager.makeRequest(localRequest {
            list {
                local {
                    uri = downloadDir.toUri()
                }
            }
        })
    }

}