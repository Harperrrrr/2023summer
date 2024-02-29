package Structure;

import java.util.HashMap;
//460
public class LFUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        int freq;
        Node(){}
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class Pile{
        Node dummy = new Node();
        Node tail = dummy;
    }

    HashMap<Integer, Pile> piles = new HashMap();
    HashMap<Integer, Node> nodes = new HashMap();
    int capacity;
    int cur_size = 0;
    int min_count = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodes.get(key);
        if(node == null){
            return -1;
        }
        changePile(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = nodes.get(key);
        if(node != null){
            node.val = value;
            changePile(node);
            return;
        }
        cur_size++;
        if(cur_size  > capacity){
            deleteNode();
        }

        node = new Node(key, value);
        nodes.put(key, node);
        addToPile(1, node);
        min_count = 1;
    }

    public void addToPile(int pile_count, Node node){
        Pile pile = piles.get(pile_count);
        if(pile == null){
            pile = new Pile();
            piles.put(pile_count, pile);
        }

        pile.tail.next = node;
        node.prev = pile.tail;
        pile.tail = node;
    }

    public void deleteNode(){
        Pile pile = piles.get(min_count);
        Node dlt = pile.dummy.next;
        nodes.remove(dlt.key);
        if(dlt == pile.tail){
            pile.dummy.next = null;
            pile.tail = pile.dummy;
            return;
        }

        Node next = dlt.next;
        pile.dummy.next = next;
        next.prev = pile.dummy;
    }

    public void changePile(Node node){
        Pile old_pile = piles.get(node.freq);
        if(node == old_pile.tail){
            old_pile.tail = node.prev;
            node.prev.next = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        if(old_pile.tail == old_pile.dummy && node.freq == min_count){
            min_count++;
        }

        node.freq++;
        addToPile(node.freq, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
