package com.example.test

import java.lang.Exception
import kotlin.system.measureTimeMillis

fun main() {
    val thread1 = Thread(CustomThread("thread1") , "thread1")
    thread1.isDaemon  = true
    CustomThread("thread2")
    CustomThreadR("thread")
    measureTimeMillis {  }

    thread1.start()

    try {
        Thread.sleep(1000)
    } catch (e: InterruptedException) {}
}

class CustomThreadR : Runnable {

    lateinit var runner: Thread
    var name: String = ""

    constructor(threadName: String) {
        name = threadName
        runner = Thread(this, name)
        println("custom thread")
        runner.start()
    }

    override fun run() {
        //display
    }

}

class CustomThread : Thread {

    constructor(threadName: String) {
        name = threadName
        start()
    }

    override fun run() {
        super.run()
    }
}

class ThreadExampe {

}