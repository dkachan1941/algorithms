
/**
 * https://www.hackerrank.com/challenges/richie-rich/problem
 */
fun main(args: Array<String>) {
    val n = 5
    val k = 1
    val s = "12321".toCharArray()
    val maxVal = "9"[0]
    val m = s.size - 1
    val rList = mutableListOf<Int>()
    var kn = 0

    s.forEachIndexed loop@{ i, _ ->
        if (i > s.size / 2 || s[i] == s[m - i] || kn > k) return@loop
        kn ++
        rList.add(i)
        if (s[i] > s[m - i]){
            s[m - i] = s[i]
        } else {
            s[i] = s[m - i]
        }
    }

    s.forEachIndexed loop@{ i, _ ->
        if ((i > s.size / 2 || k - kn == 0) ||
                (k - kn == 1 && !rList.contains(i)) ||
                (s[i] >= maxVal)) return@loop
        kn = if (rList.contains(i)) kn + 1 else kn + 2
        s[i] = maxVal
        s[m - i] = maxVal
    }

    if (k - kn > 0 && n % 2 == 1){
        s[n / 2] = maxVal
    }

    System.out.println(if (kn > k) "-1" else s.joinToString(separator = ""))
}