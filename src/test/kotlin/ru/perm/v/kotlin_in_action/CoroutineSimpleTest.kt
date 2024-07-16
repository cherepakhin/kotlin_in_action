package ru.perm.v.kotlin_in_action

import org.junit.jupiter.api.Test
import kotlin.concurrent.thread

class CoroutineSimpleTest {
    @Test
    fun runTwoThread() {
        println("My program runs...: ${Thread.currentThread().name}")

        thread { // key word "thread"!!!
            longRunningTask()
        }

        println("My program run ends...: ${Thread.currentThread().name}")
        Thread.sleep(2000) // wait for finished longRunningTask
// Output:
//        My program runs...: Test worker
//        My program run ends...: Test worker
//        longRunningTask executing on...: Thread-3
//        longRunningTask ends on thread ...: Thread-3

// if wait for finished longRunningTask time sleep = 500, then:
//        My program runs...: Test worker
//        My program run ends...: Test worker
//        executing longRunningTask on...: Thread-3
// program will finished AND don't wait longRunningTask()
    }

    fun longRunningTask(){
        println("longRunningTask executing on...: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("longRunningTask ends on thread ...: ${Thread.currentThread().name}")
    }
}