package Structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MapSum {
    class Node{
        boolean end;
        Node[] next = new Node[26];
    }

    Node head = new Node();
    HashMap<String, Integer> map = new HashMap();

    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
        addWord(key);
    }

    public int sum(String prefix) {
        List<String> strs = getStrings(prefix);
        int ans = 0;
        for(String str: strs){
            ans += map.getOrDefault(str, 0);
        }
        return ans;
    }

    public void addWord(String word){
        char[] arr = word.toCharArray();
        Node itr = head;
        for(char c: arr){
            if(itr.next[c - 'a'] == null){
                itr.next[c - 'a'] = new Node();
            }
            itr = itr.next[c - 'a'];
        }
        itr.end = true;
    }

    public List<String> getStrings(String prefix){
        char[] pre = prefix.toCharArray();
        List<String> strs = new ArrayList();
        Node itr = head;
        for(char c: pre){
            if(itr.next[c - 'a'] == null){
                return strs;
            }
            itr = itr.next[c - 'a'];
        }

        return getAllStrings(itr, prefix);
    }

    public List<String> getAllStrings(Node root, String prefix){
        List<String> res = new ArrayList();
        if(root.end){
            res.add(prefix);
        }
        for(int i = 0; i < 26; ++i){
            if(root.next[i] == null){
                continue;
            }
            List<String> list = getAllStrings(root.next[i], prefix + (char)('a' + i));
            res.addAll(list);
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */