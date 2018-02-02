fun main(args: Array<String>) {
    val n = 13
    val s = "Mr John Smith"
    var sc = s.toCharArray()
    var nc = mutableListOf<Char>()

    for (i in 0 until sc.size){
        if (sc[i] == ' '){
            nc.add('%')
            nc.add('2')
            nc.add('0')
        } else {
            nc.add(sc[i])
        }
    }
    System.out.println(nc.joinToString(separator = ""))
}
