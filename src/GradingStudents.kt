import java.util.*

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    for (n in 0 until n){
        val m = scanner.nextInt()
        when {
            m in 0 until 38 -> System.out.println(m)
            m % 5 in 3 .. 5 -> System.out.println(m - (m % 5) + 5)
            m % 5 < 3 -> System.out.println(m)
        }
    }
}