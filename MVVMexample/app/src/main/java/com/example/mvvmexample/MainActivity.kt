package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(TickViewModel::class.java)

        viewModel.tickNumber.observe(this, Observer<Int>() {
            tick_text.text = newTick.toString()

        })

        tick_button.setOnClickListener{
            viewModel.tick()
        }

    }
}