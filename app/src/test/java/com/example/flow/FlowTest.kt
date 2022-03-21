package com.example.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FlowTest {

    @Test
    fun testFlows() = runBlocking{
        val numbers = 1..10
        //COLD flow with
        val flow = numbers.asFlow().filter {
            it%2 == 0
        }.map {
            it * 10
        }.collect{ // terminal operator: launch execution
            println(it)
        }
    }
}