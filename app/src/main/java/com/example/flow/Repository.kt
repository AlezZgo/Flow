package com.example.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface Repository {

    fun currentProgress(): Flow<Int>


    class Base : Repository{
        override fun currentProgress(): Flow<Int> = flow{
            var progress = 0

            while (progress<100){
                progress+=2
                delay(50)
                emit(progress)
            }

        }.flowOn(Dispatchers.IO)

    }
}