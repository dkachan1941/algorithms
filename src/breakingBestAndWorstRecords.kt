import java.util.*

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val arr = mutableListOf<Int>()
    for (index in 0 until n){
        arr.add(scanner.nextInt())
    }

    var scoreMin = arr[0]
    var scoreMax = arr[0]
    var minCount = 0
    var maxCount = 0

    arr.forEachIndexed { _, i ->
        if (scoreMax < i) {
            maxCount ++
            scoreMax = i
        }
        if (scoreMin > i) {
            minCount ++
            scoreMin = i
        }
    }

    System.out.println("$maxCount $minCount")
}