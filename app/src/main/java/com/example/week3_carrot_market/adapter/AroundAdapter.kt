package com.example.week3_carrot_market.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week3_carrot_market.data.Around
import com.example.week3_carrot_market.databinding.ItemAroundListBinding

class AroundAdapter(private val around: List<Around>) : RecyclerView.Adapter<AroundAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(ItemAroundListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.bind(around[position])

    }

    override fun getItemCount(): Int = around.size

    inner class HomeViewHolder(private val binding: ItemAroundListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(around: Around) {

            Glide.with(itemView)
                .load(around.profileImg)
                .into(binding.ivIcon)

            binding.tvIcon.text = around.name
        }
    }

}