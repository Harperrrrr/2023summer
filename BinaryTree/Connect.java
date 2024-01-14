package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Connect {
    //116
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int num = deque.size();
            for(int i = 0; i < num - 1; ++i){
                Node n = deque.removeFirst();
                n.next = deque.getFirst();
                if(n.left != null){
                    deque.add(n.left);
                    deque.add(n.right);
                }
            }
            Node n = deque.removeFirst();
            if(n.left != null){
                deque.add(n.left);
                deque.add(n.right);
            }
        }
        return root;
    }
}
