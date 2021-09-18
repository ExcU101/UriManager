package com.excu_fcd.efm.ui.navigation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.dsl.item
import com.excu_fcd.core.dsl.requestBuilder
import com.excu_fcd.core.dsl.tag
import com.excu_fcd.core.extension.logIt
import com.excu_fcd.core.observer.Observer
import com.excu_fcd.core.provider.local.LocalProvider
import com.excu_fcd.efm.ui.layouts.ItemLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val provider = LocalProvider<String>()

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
                items(provider.provideSdcardList()) {
                    ItemLayout(localFile = it) {
                        provider.suspendedMakeRequest(request = requestBuilder {
                            operationTag(tag(1))
                            operationName("Delete operation file")
                            requestName("Simple delete operation")
                            items {
                                item(it)
                            }
                        }) { result ->
                            result.logIt()
                        }
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