
/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 */

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    for (l in 0 until n){
        val nn = scanner.nextInt()
        var s = "-1"
        for ( i in nn downTo 0){
            val n5 = i
            val n3 = nn - i
            if ((n3 == 0 && (n5 % 3 == 0)) || (n5 == 0 && (n3 % 5 == 0)) || (n5 % 3 == 0 && n3 % 5 == 0) ) {
                s = "5".repeat(n5) + "3".repeat(n3)
                break
            }
        }
        System.out.println(s)
    }
}