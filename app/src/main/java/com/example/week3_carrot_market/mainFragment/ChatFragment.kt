package com.example.week_1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3_carrot_market.R
import com.example.week3_carrot_market.adapter.ChatAdapter
import com.example.week3_carrot_market.data.Chat
import com.example.week3_carrot_market.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null

    private val binding get() = _binding!!

    private val chat = listOf(
        Chat(R.drawable.ruffy, "중욜", "산천동", "1시간 전", "넵 감사합니다!!!!!!!!"),
        Chat(R.drawable.ic_detail_profile, "블루온", "앙평동", "4시간 전", "네 알겠습니다 :)"),
        Chat(R.drawable.ruffy, "방구봉", "신내1동", "1일 전", "물건판매되었나요?"),
        Chat(R.drawable.ruffy, "무무", "신내1동", "10일 전", "물건삽니다"),
        Chat(R.drawable.ic_detail_profile, "토마베리쥬스", "방배1동", "1달 전", "넵!"),
        Chat(R.drawable.ic_detail_profile, "노란당근", "망우동", "2달 전", "넵!!!!!!!!"),
        Chat(R.drawable.ruffy, "옹심", "망우본동", "2달 전", "네고부탁드립니다"),
        Chat(R.drawable.ruffy, "상봉동주민", "논현동", "1년 전", "😻"),
        Chat(R.drawable.ic_detail_profile, "이카루스", "인창동", "2년 전", "하이"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() = with(binding) {

        //아이템 배열 형식을 세로방향인 리니어레이아웃으로 하겠다 라는 뜻 -> 방식에 따라 GridLayoutManager로도 변경 가능
        rvChatList.layoutManager = LinearLayoutManager(context)
        rvChatList.adapter = ChatAdapter(chat)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

