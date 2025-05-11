
fun main() {
    var selectedMenu = 0
    var isValidMenu = false

    while (isValidMenu == false) {
        try {
            selectedMenu = getMenuNumber()
            isValidMenu = true
        } catch (e: Exception) {
            isValidMenu = false
        }
    }

    when (selectedMenu) {
        1 -> startGame()
        2 -> createCharacter()
        3 -> endGame()
    }


}

fun getMenuNumber(): Int {
    println("메뉴를 입력해주세요.")
    println("1. 게임 시작하기")
    println("2. 캐릭터 추가")
    println("3. 게임 끝기")

    val userInput = readLine()!!.toInt()
    if(userInput < 1 || userInput > 3) {
        throw Exception("입력이 잘못되었습니다.")
    }

    return userInput
}

fun startGame() {
    println("게임이 시작되었습니다.")
}

fun createCharacter() {

    val characterList: MutableList<Map<String, String>> = mutableListOf()
    var isNeedMoreCharacter = "Y"

    while (isNeedMoreCharacter == "Y") {
        println("추가할 캐릭터의 이름을 입력해주세요.")
        // elvis 연산자 서용 ?: null일때 빈 스프링 반환
        val name = readLine() ?: ""

        println("추가할 캐릭터의 직업을 입력해주세요.")
        val job = readLine() ?: ""

        val character = mapOf("name" to name, "job" to job)
        characterList.add(character)

        println("사용자를 더 추가하시겠습니까? (Y: 추가, N: 그만두기)")
        isNeedMoreCharacter = readLine() ?: "N"
    }

    characterList.forEach {
        println(it)
    }
}

fun endGame() {
    println("게임이 종료되었습니다.")
}