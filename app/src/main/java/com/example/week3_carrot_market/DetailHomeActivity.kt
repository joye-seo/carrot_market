package com.example.week3_carrot_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.bumptech.glide.Glide
import com.example.week3_carrot_market.adapter.HomeAdapter
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.databinding.ActivityDetailHomeBinding

class DetailHomeActivity : AppCompatActivity() {

    private lateinit var sale : Sale

    private lateinit var binding : ActivityDetailHomeBinding

    private lateinit var adapter : HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sale = intent.getSerializableExtra("Data") as Sale

        clickData()
        actionBarClickListener()

    }

    private fun actionBarClickListener() = with(binding) {

        btnBack.setOnClickListener {
            onBackPressed()
        }
       btnMore.setOnClickListener {
           val popupMenu = PopupMenu(applicationContext,btnMore)
           menuInflater.inflate(R.menu.detail_menu,popupMenu.menu)

//           popupMenu.setOnMenuItemClickListener {
//
//           }
       }

    }

    private fun clickData() = with(binding) {

        Glide.with(this@DetailHomeActivity).load(sale.image).into(ivSale)
        tvAddress.text = sale.address
        tvSaleName.text = sale.itemName
        tvTime.text = sale.getFormattedMoney()
        tvContent.text = sale.getFormattedPullUp()
        tvAddress.text = sale.address

    }
}