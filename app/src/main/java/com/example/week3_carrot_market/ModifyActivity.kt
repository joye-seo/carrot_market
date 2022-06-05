package com.example.week3_carrot_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_carrot_market.databinding.ActivityModifyBinding

class ModifyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityModifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}