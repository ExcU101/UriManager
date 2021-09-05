package com.excu_fcd.efm

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.efm.dsl.metaUri
import com.excu_fcd.efm.dsl.request
import com.excu_fcd.efm.provider.LocalManager
import com.excu_fcd.efm.utils.logIt

class MainActivity : AppCompatActivity() {

    private lateinit var manager: LocalManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = request {
            name = "Simple request"
            list {
                repeat(100) {
                    add(metaUri {
                        uri = Uri.fromFile(Environment.getDataDirectory())
                    })
                }
            }
        }

        r.getUris().forEach {
            it.getName().logIt()
        }
    }
}