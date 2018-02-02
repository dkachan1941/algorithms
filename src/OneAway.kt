fun main(args: Array<String>) {
    oneAway("pale", "ple")
    oneAway("pales", "pale")
    oneAway("pale", "bale")
    oneAway("pale", "bae")
}

private fun oneAway(s1: String, s2: String){
    if (s1.length == s2.length){
        for (i in 0 until s1.length){
            if (s1.substring(i, i+1) == s1.substring(i, i+1)) {
                System.out.println("true")
                return
            }
        }
    } else {
        for (i in 0 until s1.length){
            if (s1.removeRange(i, i+1) == s2) {
                System.out.println("true")
                return
            }
        }

    }
    System.out.println("false")
}