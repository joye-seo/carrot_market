package com.example.week3_carrot_market.data

import com.example.week3_carrot_market.R
import java.io.Serializable
import java.text.DecimalFormat
object saleDB{
    val saleList : MutableList<Sale> = mutableListOf(
        Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000, false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000, false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000, false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000, false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000, false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000, false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000, false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000, false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000, false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100, false),
        Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000, false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000, false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000, false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000, false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000, false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000, false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000, false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000, false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000, false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100, false),
        Sale(R.drawable.item_1, "루피인형", "신내 1동 ", 30, 30000, false),
        Sale(R.drawable.item_2, " 안경 ", "묵동 ", 600, 20000, false),
        Sale(R.drawable.item_3, "안경팝니다!!", "상봉동 ", 800, 20000, false),
        Sale(R.drawable.item_4, "맘스보드", "신내 2동 ", 1800, 15000, false),
        Sale(R.drawable.item_5, "모니터 판매", "신내 1동 ", 3000, 150000, false),
        Sale(R.drawable.item_6, "뚜껑팝니다", "망우동 ", 7000, 2000, false),
        Sale(R.drawable.item_7, "쿠폰팝니다!!!", "상봉 1동 ", 10000, 7000, false),
        Sale(R.drawable.item_8, "서랍장판매", "중화동 ", 15000, 10000, false),
        Sale(R.drawable.item_9, "역기세트-", "면목 5동 ", 100000, 1000000, false),
        Sale(R.drawable.item_10, "크레파스", "중화 1동 ", 200000, 100, false),
    )
}

data class Sale(
    val image: Int,
    var itemName: String,
    val address: String,
    val pullUp: Int,
    var money: Int,
    var button : Boolean
): Serializable {
    fun getFormattedMoney(): String {
        val formatter = DecimalFormat("#,###")
        return "${formatter.format(money)} 원"
    }

    fun getFormattedPullUp(): String {

        val resultTime =
            when {
                pullUp < 60 -> {
                    "${pullUp}초 전"
                }
                pullUp in 60..3599 -> {
                    val minute = pullUp / 60
                    "${minute}분 전 "
                }
                pullUp in 3600..86399 -> {
                    val hour = pullUp / 3600
                    "${hour}시간 전 "
                }
                else -> {
                    val day = pullUp / 86400
                    "${day}일 전 "
                }
            }
        return resultTime
    }
}