public class ReverseAllSubs {
    
    public static Node reverseAllSubList(Node head, int k){
        Node curr = head;
        Node prev = null;

        while (true){
            Node connecter = prev; 
            Node endConnecter = curr;
            Node nextNode = null;
            for (int i = 0; curr != null && i < k; i++){
                nextNode = curr.next; 
                curr.next = prev;
                prev = curr;
                curr = nextNode; 
            }

            if (connecter != null){
                connecter.next = prev;
            } else {
                head = prev;
            }
            endConnecter.next = curr; 

            if (curr == null){
                break;
            } 
            prev = endConnecter; 
        }
        return head; 
    }

    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node newHead = ReverseAllSubs.reverseAllSubList(head, 2);
        while (newHead != null){
            System.out.print(newHead.value + " ");
            newHead = newHead.next;
        }
    }
}
