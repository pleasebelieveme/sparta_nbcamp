package coroutine

import kotlinx.coroutines.*

fun main() {
    println("1. 메인쓰레드 시작")
    var job = GlobalScope.launch {
        delay(3000)
        println("여기는 코루틴...")
    }
    // 없으면 job이 실행되지 않고 프로그램 종료
    runBlocking {
        job.join()
    }
    println("1. 메인쓰레드 종료")

    println("2. 메인쓰레드 시작")
    var job2 = CoroutineScope(Dispatchers.Default).launch {
        var fileDownloadCoroutine = async(Dispatchers.IO) {
            delay(10000)
            "파일 다운로드 완료"
        }
        var databaseConnectCoroutine = async(Dispatchers.IO) {
            delay(5000)
            "데이터베이스 연결 완료"
        }
        println("${fileDownloadCoroutine.await()}")
        println("${databaseConnectCoroutine.await()}")
    }
    runBlocking {
        job2.join()
    }
    println("2. 메인쓰레드 종료")
    job.cancel()
}