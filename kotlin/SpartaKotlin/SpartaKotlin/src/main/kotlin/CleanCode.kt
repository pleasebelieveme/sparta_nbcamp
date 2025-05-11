// 클린코드 적용전
//fun s() {
//    // 구매 안내 문구 출력
//    println("상점에 오신 것을 환영합니다.")
//    println("구매하고 싶은 아이템 숫자를 입력해주세요.")
//    // 구매할 수 있는 리스트 출력
//    println("1. 무기")
//    println("2. 갑옷")
//    println("3. 음식")
//    println("4. 약초")
//    // 사용자에게 입력받기
//    var a=readLine()!!.toInt()
//
//    // 판매할 수 있는지 확인하기
//    var b=mutableListOf(3, 2, 0, 1)
//    var c=false
//
//    if (b[a] > 0) {
//        c=true
//    } else {
//        c=false
//    }
//
//    // 판매하고 남은 재고 감소시키기
//    if(c){b[a]--
//        println("판매되었습니다!")
//    }else{ println("재고가 부족합니다!") }
//}


import kotlin.Exception

fun main() {
    val market = Market()
    market.sell()
}

class Item(
    val name: String,
    var stock: Int,
) {
    fun sell(count: Int) {
        val leftCountAfterSell = stock - count

        if (leftCountAfterSell < 0) {
            throw Exception("stock count가 부족해요!")
        }
        stock = leftCountAfterSell
    }
}

class Market {
    private val itemList = listOf(
        Item(name = "무기", stock = 3),
        Item(name = "값옷", stock = 2),
        Item(name = "음식", stock = 0),
        Item(name = "약초", stock = 1),
    )

    fun sell() {
        printWelcomeString()
        printSellableItemList()

        val itemNumberToBuy = getItemNumberToBuy()

        processSelling(itemNumberToBuy)
    }

    private fun printWelcomeString() {
        println("상점에 오신 것을 환영합니다.")
        println("구매하고 싶은 아이템 숫자를 입력해주세요.")
    }

    private fun printSellableItemList() {
        itemList.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name}")
        }
    }

    private fun getItemNumberToBuy(): Int {
        return readLine()!!.toInt()
    }

    private fun processSelling(itemNumberToBuy: Int) {
        val targetItem = itemList[itemNumberToBuy - 1]

        try {
            targetItem.sell(1)
        } catch (e: Exception) {
            println("재고가 부족합니다!")
            return
        }

        println("판매되었습니다!")
    }
}