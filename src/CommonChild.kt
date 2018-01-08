/**
 * https://www.hackerrank.com/challenges/common-child/problem
 */
fun main(args: Array<String>) {
    val s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS"
    val s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"
    var result = 0

    fun findChildSize(s1: String, s2: String) : Int?{
        var curPosition = -1
        var res = 0
        val hashMap = HashMap<Char, Int>()
        s1.forEach {item -> s2.forEachIndexed { index, it ->
            if (item == it && !hashMap.containsKey(it) && (curPosition == -1 || curPosition <= index)){
                hashMap[it] = if (hashMap.containsKey(it)) hashMap[it]!! + 1 else 1
                curPosition = index
                res ++
                return@forEach
            }
        }}
        return res
    }

    for (i in 0 until s1.length){
        val res = findChildSize(s1.substring(i, s1.length), s2) ?: 0
        result = if (res < result) result else res
    }

    System.out.println(result)
}