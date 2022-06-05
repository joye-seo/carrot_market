package com.example.week3_carrot_market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
           val popupMenu = PopupMenu(applicationContext, btnMore)
           menuInflater.inflate(R.menu.detail_menu, popupMenu.menu)

           popupMenu.setOnMenuItemClickListener { MenuItem ->

               when (MenuItem.itemId) {
                   R.id.btn_modify -> {
                       intent = Intent(this@DetailHomeActivity, ModifyActivity::class.java)
                       intent.putExtra("Data", sale)
                       startActivity(intent)
                       true
                   }
                   R.id.btn_delete ->{

//                       intent = Intent(this@DetailHomeActivity, ModifyActivity::class.java)
//                       intent.putExtra("Data", sale)
//                       startActivity(intent)
//                       finish()
//                       true

                   }

               }
               false

           }
           popupMenu.show()
       }

    }

    private fun clickData() = with(binding) {

        Glide.with(this@DetailHomeActivity).load(sale.image).into(ivSale)
        tvAddress.text = sale.address
        tvSaleName.text = sale.itemName
        tvTime.text = sale.getFormattedPullUp()
        tvMoney.text = sale.getFormattedMoney()
        tvAddress.text = sale.address

    }
}