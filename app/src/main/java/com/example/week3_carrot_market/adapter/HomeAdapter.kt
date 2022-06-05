package com.example.week3_carrot_market.adapter

import android.content.Intent
import android.icu.text.Transliterator
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.week3_carrot_market.DetailHomeActivity
import com.example.week3_carrot_market.MainActivity
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.databinding.ItemHomeSaleListBinding
import kotlinx.coroutines.delay
import java.util.logging.Handler

class HomeAdapter(private val sale: List<Sale>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        Log.d("adapter", "onCreateViewHolder")
       val  binding = ItemHomeSaleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeViewHolder(binding).also {
            binding.btnSwitch.setOnCheckedChangeListener { compoundButton, b ->
                sale[it.adapterPosition].button = b
             }
        }
        // 체크 안풀리게 처리해주는 코드!

        //attachToParent :  parent에 연결 시킬 때 직접 생성할때 하는게 아닌 리사이클러뷰가 알아서 해줘야 함! 그러므로 false 사용

    }
    // 호출되는 횟수가 정해져 있음
    // 뷰홀더를 만든다는건 이름 그대로 뷰를 만든다는 의미와 같음

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        Log.d("adapter", "onBindViewHolder")
        holder.bind(sale[position])

    }
    // 스크롤 하면 할수록 계속 호출 됨

    //함수 객체가 계속 호출할떄마다 계속 새엉해서 넣어주기 때문에 뷰를 재활용하는데에는 성공하지만
    //체크 확인하는 곳에서는 실패한 것 -> onBindViewHolder에 넣는게 아닌 onCreateViewHolder에 넣어야함

    override fun getItemCount(): Int = sale.size
    //총 몇개 그려야 하니? -> 서버에서 받아서 로딩 할때 등등


    inner class HomeViewHolder(private val binding: ItemHomeSaleListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sale: Sale) {

            Glide.with(itemView)
                .load(sale.image)
                .transform(MultiTransformation(CenterCrop(), RoundedCorners(30)))
                .into(binding.ivSale)

            binding.tvAddress.text = sale.address
            binding.tvItemName.text = sale.itemName
            binding.tvMoney.text = sale.getFormattedMoney()
            binding.tvPullUp.text = sale.getFormattedPullUp()
            binding.btnSwitch.isChecked = sale.button


            itemView.setOnClickListener {

                val myIntent = Intent(itemView.context, DetailHomeActivity::class.java)
                myIntent.putExtra("Data", sale)
                itemView.context.startActivity(myIntent)
            }




        }
    }

}