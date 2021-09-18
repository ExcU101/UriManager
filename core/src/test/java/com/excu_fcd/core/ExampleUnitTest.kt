package com.excu_fcd.core

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val path = "/storage/some/directory"
//        val name = path.substring(path.lastIndexOf("/") + 1)
//        val parentPath = path.substring(0, path.indexOf(name) - 1)
//        val newDirectory = "$parentPath/Sigh"
//
//        println(path)
//        println(name)
//        println(parentPath)
//        println(newDirectory)

        val ch = "Create 1"
        val job = "Create s job"

        var l = listOf("Create", "create", "create provider")

        println(ch.contains("create"))
        println(job.contains(ch))
        println(l.contains(ch))

//        val start = System.currentTimeMillis()
//        val end = System.currentTimeMillis()
//        println(start)
//        println(end)
    }

}