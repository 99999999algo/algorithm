package main.kotlin.sort

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */
fun main() {
    val numbers = intArrayOf(0, 0, 0, 0, 0)
    println(solution(numbers))
    println(solution2(numbers))
}

private fun solution(numbers: IntArray): String {
    var answer = ""

    val sortedArray = numbers.map {
        it.toString()
    }.sortedWith(
        Comparator { o1, o2 ->
            if (o1.length == o2.length) { // 길이가 같다면 큰게 첫번째로 오게 한다. > o2.compareTo(o1) == o2 - o1
                o2.compareTo(o1)
            } else {
                // 길이가 다르다면, 앞에 있는 문자와 뒤의 있는 문자의 조합을 비교한다.
                (o2 + o1).compareTo(o1 + o2)
                // 3 , 30 -> 330  compare 303
            }
        }
    )
    if (sortedArray[0] == "0") {
        answer += "0"
    } else {
        for (i in sortedArray) {
            answer += i
        }
    }

    return answer
}

private fun solution2(numbers: IntArray): String {
    var answer = ""
    numbers.sortedWith(
        Comparator { num1: Int, num2: Int ->
            "$num2$num1".compareTo("$num1$num2")
        }
    ).forEach { answer += it }
    if (answer[0] == '0') {
        answer = "0"
        return answer
    }
    return answer
}
