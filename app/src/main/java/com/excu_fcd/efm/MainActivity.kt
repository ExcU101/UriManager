package com.excu_fcd.efm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.core.data.local.LocalItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        val d = LocalItem("")
        d + "/s" //this(d + "s") = path + "s"
        super.onStart()
    }

}