
fun main(args: Array<String>) {
    val s = "aabcccccaaa"
    if (s.length < 2) return
    var temp = s.substring(0,1)
    var counter = 1
    var sb = StringBuilder()
    for (i in 1 until s.length){
        when {
            i==s.length-1 -> sb.append("${s.substring(i-1,i)}${counter+1}")
            temp != s.substring(i, i+1) -> {
                temp = s.substring(i, i+1)
                sb.append("${s.substring(i-1,i)}$counter")
                counter = 1
            }
            else -> counter++
        }
    }
    System.out.println(sb.toString())
}