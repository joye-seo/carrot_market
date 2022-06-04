package com.example.week3_carrot_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.databinding.ActivityDetailHomeBinding

class DetailHomeActivity : AppCompatActivity() {

    private lateinit var sale : Sale

    private lateinit var binding : ActivityDetailHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun clickData(){


    }
}