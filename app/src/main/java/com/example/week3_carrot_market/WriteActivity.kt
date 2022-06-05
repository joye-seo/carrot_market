package com.example.week3_carrot_market

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.week3_carrot_market.databinding.ActivityWriteBinding
import com.example.week_1.Fragment.HomeFragment

class WriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWriteBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        binding.btnFinish.setOnClickListener {

            val title = binding.tvTitle.text.toString()
            val money = binding.tvMoney.text.toString()

            var homeFragment = HomeFragment()

            val bundle = bundleOf("title" to title, "money" to money)
                homeFragment.arguments = bundle

            this?.supportFragmentManager!!.beginTransaction()
                .replace(R.id.rv_home_sale_list, homeFragment)
                .commit()
       }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}