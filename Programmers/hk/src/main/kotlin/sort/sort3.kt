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
    val citations = intArrayOf(0,0,0,0,0)
    println(solution(citations = citations))
}
private fun solution(citations: IntArray): Int {
    var result = 0
    val sortedArray = citations.sortedWith(Comparator { o1, o2 -> o2 - o1 })

    println(sortedArray)
    if (sortedArray[0] == 0) {
        result = 0
    } else {
        for (i in 0 until sortedArray.size) {
            val indexValue = sortedArray[i]

            /*
            6 0
            5 1
            3 2
            1 3
            0 4
             */
            /*

            4 0
            1 1
             */

            if (indexValue >= i) {
                if (indexValue == i) {
                    result = i
                } else {
                    result = i + 1
                }
            }
        }
    }

    return result
}
