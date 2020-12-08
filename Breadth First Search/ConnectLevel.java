import java.util.*;

class node{
    int val;
    node left;
    node right;
    node next;

    node(int x){
        val = x;
        left = right = next = null;
    }

void printLevelOrder(){
    node nextLevelRoot = this;
    while (nextLevelRoot != null){
        node current = nextLevelRoot;
        nextLevelRoot = null;
        while (current != null){
            System.out.print(current.val + " ");
            if (nextLevelRoot == null) {
                if (current.left != null){
                    nextLevelRoot = current.left;
                } else if (current.right != null) {
                    nextLevelRoot = current.right;
                }
            } 
            current = current.next;
        }
        System.out.println();
    }
}
};


class ConnectLevel {
    public static void connect(node root){
        Queue<node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            node prev = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                node currNode = queue.poll();
                if (prev != null){
                    prev.next = currNode;
                }
                prev = currNode;

                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        node root = new node(12);
        root.left = new node(7);
        root.right = new node(1);
        root.left.left = new node(9);
        root.right.left = new node(10);
        root.right.right = new node(5);
        ConnectLevel.connect(root);
        root.printLevelOrder();
    }
}
