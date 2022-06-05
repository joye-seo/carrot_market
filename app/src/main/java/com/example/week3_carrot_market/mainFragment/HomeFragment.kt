package com.example.week_1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3_carrot_market.R
import com.example.week3_carrot_market.adapter.HomeAdapter
import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.data.saleDB
import com.example.week3_carrot_market.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!



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
        rvHomeSaleList.adapter = HomeAdapter(saleDB.saleList)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}