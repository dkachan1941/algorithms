package linkedlist

fun main(args: Array<String>) {

    val cls = RemoveDups()

    var n = RemoveDups.Node(2)
    n.next = RemoveDups.Node(2)
    n.next?.next = RemoveDups.Node(2)
    n.next?.next?.next = RemoveDups.Node(3)
    n.next?.next?.next?.next = RemoveDups.Node(4)
    n.next?.next?.next?.next?.next = RemoveDups.Node(4)
    n.next?.next?.next?.next?.next?.next = RemoveDups.Node(2)

    System.out.println("Original List : ")

    cls.printLinkedList(n)

    System.out.println("New List : ")

    cls.removeDubsNoHashMap(n)
//    linkedlist.removeDubs(n)

    cls.printLinkedList(n)

}

class RemoveDups{

    fun removeDubs(n: Node): Node {
        val hm = HashMap<Int,Boolean>()

        var prevValue = n
        var curValue = n.next
        var temp: Node? = null //keeping it so that last node would be eligible for garbage collection

        hm[prevValue.data] = true
        while (curValue != null){
            if (hm.contains(curValue.data)){
                prevValue.next = curValue.next
                temp = curValue
                curValue = curValue.next
                temp.next = null
            } else {
                hm[curValue.data] = true
                prevValue = curValue
                curValue = curValue.next
            }
        }
        return n
    }

    fun removeDubsNoHashMap(n: Node?){
        var cur = n
        while (cur != null){
            var runner = cur
            while (runner?.next != null){
                if (cur.data == runner.next?.data){
                    runner.next = runner.next?.next
                } else {
                    runner = runner.next
                }
            }
            cur = cur.next
        }
    }

    fun printLinkedList(n: Node?){
        System.out.println(n?.data)
        if (n?.next != null) printLinkedList(n.next!!)
    }

    class Node(var data:Int){
        var next: Node? = null
        var prev: Node? = null
    }
}