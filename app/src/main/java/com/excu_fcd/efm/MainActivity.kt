package com.excu_fcd.efm

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.excu_fcd.efm.dsl.localRequest
import com.excu_fcd.efm.dsl.local
import com.excu_fcd.efm.provider.LocalManager

class MainActivity : AppCompatActivity() {

    private val manager: LocalManager by lazy {
        LocalManager(context = this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        localRequest {
            list {

            }
        }


        manager.compileRequest(request = localRequest {
            list {
                local {
                    uri = Uri.fromFile(Environment.getRootDirectory())
                }
            }
        })
    }
}