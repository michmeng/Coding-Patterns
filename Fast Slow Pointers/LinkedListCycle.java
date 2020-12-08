import java.util.*; 

class Node{
    int value = 0;
    Node next; 

    Node(int value){
        this.value = value;
    }
}

public class LinkedListCycle {
    
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head; 
        while (fast != null && slow != null){
            fast = fast.next.next; 
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println(LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next = head.next.next; 
        System.out.println(LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next = head.next.next.next; 
        System.out.println(LinkedListCycle.hasCycle(head));
    }
}
