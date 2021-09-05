package com.excu_fcd.efm

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.efm.dsl.item
import com.excu_fcd.efm.dsl.request
import com.excu_fcd.efm.provider.LocalManager
import com.excu_fcd.efm.utils.logIt

class MainActivity : AppCompatActivity() {

    private val manager: LocalManager by lazy {
        LocalManager(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = request {
            name = "Simple request"
            list {
                repeat(100) {
                    item {
                        uri = Uri.fromFile(Environment.getRootDirectory())
                    }
                    item {
                        uri = Uri.fromFile(Environment.getRootDirectory())
                    }
                    item {
                        uri = Uri.fromFile(Environment.getRootDirectory())
                    }
                }
            }
        }

        r.getUris().forEach {
            it.getName().logIt()
        }
    }
}