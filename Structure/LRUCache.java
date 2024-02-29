package Structure;

import java.util.HashMap;
//146
public class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int val;

        Node(){
        }

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int cur_size = 0;
    HashMap<Integer, Node> map = new HashMap();
    Node head = new Node();
    Node tail = head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = map.get(key);

        if(n == null) return -1;
        moveToTail(n);

        return n.val;
    }

    public void put(int key, int value) {
        Node tmp = map.get(key);
        if(tmp != null){
            tmp.val = value;
            moveToTail(tmp);
            return;
        }
        Node new_node = new Node(key, value);
        map.put(key, new_node);
        addNode(new_node);

        cur_size++;
        if(cur_size > capacity){
            int dlt_key = deleteNode();
            map.remove(dlt_key);
            cur_size = capacity;
        }
    }

    public void addNode(Node n){
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public int deleteNode(){
        if(head.next == tail){
            int dlt_key = tail.key;
            tail = head;
            return dlt_key;
        }

        Node dlt = head.next;
        Node next = dlt.next;

        head.next = next;
        next.prev = head;

        return dlt.key;
    }

    public void moveToTail(Node node){
        if(node == tail) return;

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */