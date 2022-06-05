package com.example.week3_carrot_market

import com.example.week3_carrot_market.data.Sale
import com.example.week3_carrot_market.data.saleDB

class DBHelper {

    // 메모 추가.
    fun create(title: String, money: String) {
        val item =Sale(R.drawable.item_1, itemName = title, "신내 1동 ", 30, money=money.toInt(), false)
        saleDB.saleList.add(item)
    }

    // 메모 삭제.
    fun delete(memoId:Long){
        // todo 메모 삭제 로직 구현.
    }

    // 메모 수정.
    fun modify(memoId:Long, subject:String, content:String){
        // todo 메모 수정 로직 구현.
    }

}