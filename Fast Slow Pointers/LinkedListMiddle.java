import java.util.*;

class LLNode{
    int value = 0;
    LLNode next;

    LLNode(int value){
        this.value = value;
    }
}

public class LinkedListMiddle {
    
    public static LLNode middleNode(LLNode head){
        LLNode slow = head;
        LLNode fast = head.next;
        while (fast != null){
            if (fast.next == null){
                slow = slow.next;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }

    public static void main(String[] arg){
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);
        System.out.println(LinkedListMiddle.middleNode(head).value);
        head.next.next.next.next.next = new LLNode(6);
        System.out.println(LinkedListMiddle.middleNode(head).value);
        head.next.next.next.next.next.next = new LLNode(7);
        System.out.println(LinkedListMiddle.middleNode(head).value);
    }
}
