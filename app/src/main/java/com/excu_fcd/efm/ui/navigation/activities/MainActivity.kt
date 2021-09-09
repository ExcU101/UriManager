package com.excu_fcd.efm.ui.navigation.activities

import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.excu_fcd.core.data.local.LocalItem
import com.excu_fcd.efm.ui.layouts.ItemLayout

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }

    @Composable
    fun Main() {
        MaterialTheme {
            LazyColumn() {
                items(Environment.getExternalStorageDirectory().listFiles()!!.map {
                    LocalItem(it)
                }) {
                    ItemLayout(localItem = it) {
                        Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    @Preview(name = "Main", device = Devices.DEFAULT)
    @Composable
    fun MainPreview() {
        Main()
    }

}