package com.example.week_1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3_carrot_market.adapter.HomeAdapter
import com.example.week3_carrot_market.R
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var sales = listOf(
        Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000,false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000,false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000,false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000,false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000,false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000,false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000,false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000,false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000,false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100,false),
        Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000,false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000,false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000,false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000,false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000,false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000,false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000,false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000,false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000,false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100,false), Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000,false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000,false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000,false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000,false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000,false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000,false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000,false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000,false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000,false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100,false),
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() = with(binding) {

        //아이템 배열 형식을 세로방향인 리니어레이아웃으로 하겠다 라는 뜻 -> 방식에 따라 GridLayoutManager로도 변경 가능
        rvHomeSaleList.layoutManager = LinearLayoutManager(context)
        rvHomeSaleList.adapter = HomeAdapter(sales)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}