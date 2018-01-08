import java.lang.Math.abs
import java.lang.Math.max

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
fun main(args: Array<String>) {
    val s = "abcccc"
    val hashMap = HashMap<Char, Int>()
    s.forEach { hashMap[it] = if (hashMap.containsKey(it)) hashMap[it]!! + 1 else 1 }
    val maxVal = hashMap.filter { it.value == hashMap.maxBy { it.value }?.value }
    val res = if (max(maxVal.size, hashMap.filter { it.value == hashMap.minBy { it.value }?.value }.size) >= hashMap.size - 1 && (
            abs(hashMap.filter { it.value == hashMap.minBy { it.value }?.value }.maxBy { it.value }?.value!! - maxVal.maxBy { it.value }?.value!!) <= 1 ||
            hashMap.filter { it.value == hashMap.minBy { it.value }?.value }.size <= 1)
            ) "YES" else "NO"
    System.out.println(res)
}