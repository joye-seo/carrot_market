package com.example.week3_carrot_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_carrot_market.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}