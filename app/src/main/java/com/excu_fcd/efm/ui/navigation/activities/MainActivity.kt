package com.excu_fcd.efm.ui.navigation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.core.provider.LocalProvider
import com.excu_fcd.efm.R

class MainActivity : AppCompatActivity() {

    private val localProvider: LocalProvider by lazy {
        LocalProvider(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
    }

}