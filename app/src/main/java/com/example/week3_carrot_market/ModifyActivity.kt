package com.example.week3_carrot_market

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
//            val intent = Intent(this,DetailHomeActivity::class.java)
//            intent.putExtra("ModifyTitle", binding.tvTitle.toString()).putExtra("ModifyMoney",binding.tvMoney.toString())
//            setResult(RESULT_OK,intent)
//            finish()

            val title = binding.tvTitle.text.toString()
            val money = binding.tvMoney.text.toString()
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