fun main() {

    var name: String = "김르탄"
    println(name)
    println("내 이름은 ${name}이에요.")

    // 입력
    val dataString = readLine()
    println("나는 ${dataString}를 입력했어요")

    // !! -> 널처리를 위한 코드
    val dataNumber = readLine()!!.toInt()
    val sum = dataNumber + 3
    println("입력은 ${dataNumber}인데 3을 더해서 ${sum}이에요!")

    // if-else
    if(false) {
        println("if문 참")
    } else {
        println("if문 거짓")
    }

    // when
    when (true) {
        true -> {
            println("값이 true입니다.")
        }
        false -> {
            println("값이 false입니다.")
        }
    }

}