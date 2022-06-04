package com.example.week3_carrot_market.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.week3_carrot_market.data.Chat
import com.example.week3_carrot_market.databinding.ItemChatListBinding

class ChatAdapter(private val chat: List<Chat>) : RecyclerView.Adapter<ChatAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        return HomeViewHolder(ItemChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.bind(chat[position])

    }
    // 스크롤 하면 할수록 계속 호출 됨

    //함수 객체가 계속 호출할떄마다 계속 새엉해서 넣어주기 때문에 뷰를 재활용하는데에는 성공하지만
    //체크 확인하는 곳에서는 실패한 것 -> onBindViewHolder에 넣는게 아닌 onCreateViewHolder에 넣어야함

    override fun getItemCount(): Int = chat.size
    //총 몇개 그려야 하니? -> 서버에서 받아서 로딩 할때 등등


    inner class HomeViewHolder(private val binding: ItemChatListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(chat: Chat) {

            Glide.with(itemView)
                .load(chat.profileImg)
                .transform(MultiTransformation(CenterCrop(), RoundedCorners(300)))
                .into(binding.ivProfile)

            binding.tvAddress.text = chat.address
            binding.tvId.text = chat.id
            binding.tvTalk.text = chat.talk
            binding.tvTime.text = chat.time


        }
    }

}