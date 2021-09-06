package com.excu_fcd.efm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.efm.provider.LocalManager
import com.excu_fcd.efm.provider.RemoteManager

class MainActivity : AppCompatActivity() {

    private val manager: LocalManager by lazy {
        LocalManager(context = this)
    }

    private val remoteManager: RemoteManager by lazy {
        RemoteManager(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}