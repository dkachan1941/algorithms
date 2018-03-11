package datastructures;

public class InsertNodeTailLinkedList {

    Node Insert(Node head,int data) {
        return insertDS(head, data, head);
    }
    Node insertDS(Node head, int data, Node parent){
        if (head == null){
            head = new Node();
            head.data = data;
            if(parent != null) parent.next = head;
        } else
            insertDS(head.next, data, head);
        return head;
    }

}
