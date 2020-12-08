public class Reverse {
    
    public static Node reverseLinkedList(Node head){
        Node prev = null; 
        Node curr = head; 
        Node next = null; 
        while (curr != null){
            next = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        return prev; 
    }

    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node newHead = Reverse.reverseLinkedList(head);
        while (newHead != null){
            System.out.print(newHead.value + " ");
            newHead = newHead.next;
        }
    }
}
