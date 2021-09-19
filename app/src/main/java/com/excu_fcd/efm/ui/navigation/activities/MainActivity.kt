package com.excu_fcd.efm.ui.navigation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.excu_fcd.core.data.local.LocalFile
import com.excu_fcd.core.data.request.Request
import com.excu_fcd.core.dsl.builder
import com.excu_fcd.core.dsl.item
import com.excu_fcd.core.dsl.tag
import com.excu_fcd.core.extension.logIt
import com.excu_fcd.core.provider.local.LocalProvider
import com.excu_fcd.efm.ui.layouts.ItemLayout
import com.excu_fcd.efm.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val provider = LocalProvider<String>()
    private val model by viewModels<ViewModel>()

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
                val builder = builder<LocalFile, String> {
                    operationTag(tag(1))
                    operationName("Delete operation file")
                    requestName("Simple delete operation")
                }
                model.getData().observe(this@MainActivity) {
                    items(it) { file ->
                        ItemLayout(localFile = file) {
                            builder.items {
                                item(file)
                            }
                            val request = builder.build()
                            provider.suspendedMakeRequest(request = request) { result ->
                                result.logIt()
                                if (request.getStatus() == Request.Status.SUCCESS) {
                                    model.getData().value!!.remove(file)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//    @Preview(name = "Main", device = Devices.DEFAULT)
//    @Composable
//    fun MainPreview() {
//        Main()
//    }

}