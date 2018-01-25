
/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
fun main(args: Array<String>) {
//    val list = listOf(1, 7, 2, 4)
//    val list = listOf(2, 7, 12, 17, 22)
//    val list = listOf(770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493)
    val list = listOf(582740017, 954896345, 590538156, 298333230, 859747706, 155195851, 331503493, 799588305, 164222042, 563356693, 80522822, 432354938, 652248359)
    val k  = 11
    val subset = mutableListOf<Int>()

//    for (i in list.indices){
//        for (j in i + 1 until list.size){
//            if ((list[i] + list[j]) % k != 0) {
//                if (!subset.contains(list[i])) subset.add(list[i])
//                if (!subset.contains(list[j])) subset.add(list[j])
//            }
//        }
//    }

    for (i in list.indices){
        for (j in i + 1 until list.size){
            if ((list[i] + list[j]) % k == 0) {
                if (!subset.contains(list[i])) subset.add(list[i])
                if (!subset.contains(list[j])) subset.add(list[j])
                System.out.println("${list[i]} + ${list[j]} % k = ${(list[i] + list[j])} % $k = ${(list[i] + list[j]) % k}")
            }
        }
    }
    System.out.println(subset)


//    var max = 0
//    for (i in 0..list.size - 2){
//        if ((list[i] + list[i + 1]) % k != 0){
//            if (subset.size == 0) {
//                subset.add(list[i])
//                subset.add(list[i + 1])
//            } else {
//                subset.add(list[i + 1])
//            }
//        } else {
//            if (subset.size > max) max = subset.size
//            subset.clear()
//        }
//    }
//    if (subset.size > max) max = subset.size
//    System.out.println(max)

//    System.out.println((0 until s.size).count { s.size > it + m - 1 && s.subList(it, it + m).sum() == d })
}