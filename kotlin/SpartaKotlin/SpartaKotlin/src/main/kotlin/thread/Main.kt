package thread

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
        thread(start = true) {
            for(i in 1..10) {
                println("Thread1: 현재 숫자는 ${i}")
                runBlocking {
                    launch {
                        delay(1000)
                    }
                }
            }
        }

        thread(start = true) {
            for(i in 50..60) {
                println("Thread2: 현재 숫자는 ${i}")
                runBlocking {
                    launch {
                        delay(1000)
                    }
                }
            }
        }
    }
