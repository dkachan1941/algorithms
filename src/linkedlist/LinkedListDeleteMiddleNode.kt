package linkedlist

fun main(args: Array<String>) {

    val cls = DeleteMiddleNode()

    val n = DeleteMiddleNode.Node('a')
    val n2 = DeleteMiddleNode.Node('b')
    val n3 = DeleteMiddleNode.Node('c')
    val n4 = DeleteMiddleNode.Node('d')
    val n5 = DeleteMiddleNode.Node('e')
    val n6 = DeleteMiddleNode.Node('f')
    val n7 = DeleteMiddleNode.Node('f')

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

    System.out.println("after removal:")

    cls.deleteNode(n, 'c')
    cls.printLinkedList(n)

}

class DeleteMiddleNode{

    fun deleteNode(head: Node, node: Char){

        var prev = head
        var headNode = head

        while (headNode.next != null){
            if (headNode.data == node){
                prev.next = headNode.next
            } else {
                prev = headNode
            }
            headNode = headNode.next!!
        }

//        printLinkedList(prev)
    }

    fun printLinkedList(n: Node?){
        System.out.println(n?.data)
        if (n?.next != null) printLinkedList(n.next!!)
    }

    class Node(var data:Char){
        var next: Node? = null
        var prev: Node? = null
    }
}