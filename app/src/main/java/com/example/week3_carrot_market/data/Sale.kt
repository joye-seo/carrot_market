package com.example.week3_carrot_market.data

import java.io.Serializable
import java.text.DecimalFormat

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