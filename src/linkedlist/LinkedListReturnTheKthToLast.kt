package linkedlist

fun main(args: Array<String>) {

    val cls = ReturnTheKthToLast()

    val n = ReturnTheKthToLast.Node(2)
    val n2 = ReturnTheKthToLast.Node(2)
    val n3 = ReturnTheKthToLast.Node(2)
    val n4 = ReturnTheKthToLast.Node(3)
    val n5 = ReturnTheKthToLast.Node(5)
    val n6 = ReturnTheKthToLast.Node(4)
    val n7 = ReturnTheKthToLast.Node(2)

    n.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    n6.next = n7
    n7.prev = n6
    n6.prev = n5
    n5.prev = n4
    n4.prev = n3
    n3.prev = n2
    n2.prev = n

    System.out.println("Original List : ")

    cls.printLinkedList(n)

    System.out.println("1st approach: Kth el : " + cls.getKthToLast(n, k = 3))

    cls.printKthToLast(n, 3)

    System.out.println("3st Iterative approach: Kth el : " + cls.printKthToLastIterative(n, 3))

}

class ReturnTheKthToLast{

    // 3nd approach - iterative
    fun printKthToLastIterative(head: Node?, k: Int): Int?{
        var head1 = head
        var head2 = head

        for (i in 0 until k){
            head1 = head1?.next
        }

        while (head1 != null){
            head1 = head1?.next
            head2 = head2?.next
        }

        return head2?.data
    }

    // 2nd approach
    fun printKthToLast(head: Node?, k: Int): Int{
        if (head == null){
            return 0
        }
        val index = printKthToLast(head?.next, k) + 1
        if (index == k) {
            System.out.println("$k th to last node is ${head?.data}")
        }
        return index
    }

    // 1st approach
    fun getKthToLast(n: Node?, backWay: Boolean = false, position: Int = 0, k: Int) : Int?{
        if (backWay && (k == 0 || position == k)) return n?.data
        return if (backWay){
            getKthToLast(n?.prev, true, position + 1, k)
        } else {
            if(n?.next == null){
                getKthToLast(n, true, position+1, k)
            } else {
                getKthToLast(n.next, backWay, position, k)
            }
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