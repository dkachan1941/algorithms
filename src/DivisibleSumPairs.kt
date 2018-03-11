import java.util.*

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
fun main(args: Array<String>) {

//    val scanner = Scanner(System.`in`)
//    val n = scanner.nextInt()
//    val k = scanner.nextInt()
//    val arr = mutableListOf<Int>()
//    for (index in 0 until n){
//        arr.add(scanner.nextInt())
//    }

    val arr = mutableListOf(1, 3, 2, 6, 1, 2)

    var res = 0


    for (i in 0 until arr.size){
        for (j in i + 1 until arr.size){
            if ((arr[i] + arr[j]) % 3 == 0){
                res ++
            }
        }
    }

    System.out.println("$res")
}