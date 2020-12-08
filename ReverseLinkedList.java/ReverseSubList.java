public class ReverseSubList {

    public static Node reverseSubList(Node head, int p, int q){
        Node curr = head;
        Node prev = null;
        for (int i = 0; curr != null && i < p - 1; ++i){
            prev = curr;
            curr = curr.next;
        }

        Node connecter = prev; 
        Node endConnecter = curr;
        Node nextNode = null;
        for (int i = 0; curr != null && i < q-p+1; i++){
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
        return head;
    }

    public static void main(String[] args){
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);

        Node newHead = ReverseSubList.reverseSubList(head, 2, 4);
        while (newHead != null){
            System.out.print(newHead.value + " ");
            newHead = newHead.next;
        }
    }
}
