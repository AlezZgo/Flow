package com.example.flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.junit.Test

class FlowTest {

    @Test
    fun testFlows() = runBlocking{
        //COLD flow with
        val flow = flowOf(1,2,3,4,5).filter {
            it%2 == 0
        }.map {
            it * 10
        }.collect{ // terminal operator: launch execution
            println(it)
        }
    }
}