
/**
 * https://www.hackerrank.com/challenges/common-child/problem
 */
fun main(args: Array<String>) {
    val s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS"
    val s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"

    fun findChildSize(s1: String, s2: String) : Int?{
        var res = 0
        var index = 0
        s1.forEach { item ->
            for (i in index until s2.length){
                if (item == s2[i]){
                    res ++
                    index = i + 1
                    break
                }
            }
        }
        return res
    }

    var result = 0
    for (j in 0 until s1.length){
        val res = findChildSize(s1.substring(j, s1.length), s2) ?: 0
        result = if (res > result) res else result
    }

    System.out.println(result)

}