package linkedlist

fun main(args: Array<String>) {

    val cls = Partition()

    val n = Partition.Node(6)
    val n2 = Partition.Node(2)
    val n3 = Partition.Node(1)
    val n4 = Partition.Node(3)
    val n5 = Partition.Node(5)
    val n6 = Partition.Node(4)
    val n7 = Partition.Node(1)

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

    System.out.println("Modificated List : ")

    cls.printLinkedList(cls.partitionLinkedList(n, 5))

}

class Partition{

    fun partitionLinkedList(n:Node, x: Int): Node? {
        var beforeStart: Node? = null
        var beforeEnd: Node? = null
        var afterStart: Node? = null
        var afterEnd: Node? = null
        var node: Node? = n

        while (node != null){
            var next: Node? = node.next
            if (node.data < x){
                // Insert node into end of before list
                if (beforeStart == null) {
                    beforeEnd = node
                    beforeEnd = beforeStart
                } else {
                    beforeEnd?.next = node
                    beforeEnd = node
                }
            } else {
                // Insert node into end of after list
                if (afterStart == null){
                    afterStart = node
                    afterEnd = afterStart
                } else {
                    afterEnd?.next = node
                    afterEnd = node
                }
            }
            node = next
        }

        if(beforeStart == null) {
            return afterStart
        }

        // Merge before list after list
        beforeEnd?.next = afterStart
        return beforeStart
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