package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flow.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        binding.button.setOnClickListener {
            val rep = Repository.Base()
            runBlocking {
                rep.currentProgress().collect {
                    binding.tv.text = it.toString()
                }
            }
        }

        setContentView(binding.root)


    }
}