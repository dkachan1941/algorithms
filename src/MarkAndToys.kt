/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 */
fun main(args: Array<String>) {
    val n = 7
    val k =50
    val toys = listOf(1, 12, 5, 111, 200, 1000, 10).sorted()
    var sum = 0
    var res = 0
    toys.forEachIndexed loop@{ index, i ->
        if (sum + i <= k) {
            sum += i
            res ++
        } else {
            return@loop
        }
    }

    System.out.println(res)
}