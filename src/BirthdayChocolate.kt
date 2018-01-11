import java.util.*

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val s = mutableListOf<Int>()
    for (i in 0 until n){
        s.add(scanner.nextInt())
    }
    val d = scanner.nextInt()
    val m = scanner.nextInt()
    System.out.println((0 until s.size).count { s.size > it + m - 1 && s.subList(it, it + m).sum() == d })
}