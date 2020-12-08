import java.util.*; 

// class Node{
//     int value = 0;
//     Node next; 

//     Node(int value){
//         this.value = value;
//     }
// }

public class StartOfLinkedListCycle{
    
    public static Node inCycle(Node head){
        Node slow = head;
        Node fast = head; 
        while (fast != null && slow != null){
            fast = fast.next.next; 
            slow = slow.next;
            if (slow == fast){
                return slow;
            }
        }
        return new Node(-1);
    }

    public static int cycleLength(Node head){
        Node cycleNode = StartOfLinkedListCycle.inCycle(head); 
        if (cycleNode.next != null){
            int length = 1;
            Node curr = cycleNode.next;
            while (curr != cycleNode){
                length += 1; 
                curr = curr.next; 
            }
            return length; 
        }
        return 0;
    }

    public static Node startCycle(Node head){
        int cycleLength = StartOfLinkedListCycle.cycleLength(head); 
        if (cycleLength != 0){
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < cycleLength; i++){
                fast = fast.next; 
            }
            while (fast != null && slow != null){
                fast = fast.next;
                slow = slow.next;
                if (slow == fast){
                    return slow;
                }
            }
            return new Node(-1);
        } else {
            return new Node(-1);
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println(StartOfLinkedListCycle.startCycle(head).value);

        head.next.next.next.next.next = head.next.next; 
        System.out.println(StartOfLinkedListCycle.startCycle(head).value);

        head.next.next.next.next.next = head.next.next.next; 
        System.out.println(StartOfLinkedListCycle.startCycle(head).value);
    }
}