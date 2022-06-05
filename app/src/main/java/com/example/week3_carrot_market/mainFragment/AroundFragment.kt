package com.example.week_1.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week3_carrot_market.R
import com.example.week3_carrot_market.adapter.AroundAdapter
import com.example.week3_carrot_market.data.Around
import com.example.week3_carrot_market.databinding.FragmentAroundBinding

class AroundFragment : Fragment() {

    private var _binding : FragmentAroundBinding? = null

    private val binding get() = _binding!!

    private val around = listOf(
        Around(R.drawable.img_3,"쿠폰북"),
        Around(R.drawable.img_4,"알바"),
        Around(R.drawable.img_5,"부동산\n직거래"),
        Around(R.drawable.img_6,"농수산물"),
        Around(R.drawable.img,"중고차\n직거래"),
        Around(R.drawable.img_1,"과외/클래스"),
        Around(R.drawable.img_8,"쿠폰북"),
        Around(R.drawable.img_2,"당근미니"),

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAroundBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
    }

    private fun initializeViews() = with(binding) {

        rvAroundList.layoutManager = GridLayoutManager(context,4)
        rvAroundList.adapter = AroundAdapter(around)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}