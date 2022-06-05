package com.example.week3_carrot_market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.databinding.ActivityModifyBinding

class ModifyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityModifyBinding

    private lateinit var sale : Sale

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEvents()

        sale = intent.getSerializableExtra("Data") as Sale
        clickData()

    }

    private fun setEvents(){
        binding.btnFinish.setOnClickListener {
            val intent = Intent(this,DetailHomeActivity::class.java)
            intent.putExtra("Data",sale)
            setResult(RESULT_OK,intent)
            finish()
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun clickData() = with(binding) {

        Glide.with(this@ModifyActivity).load(sale.image).into(ivSale)
        tvTitle.setText(sale.itemName)
        tvMoney.setText(sale.money.toString())

    }

}