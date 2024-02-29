package Structure;
// 211
public class WordDictionary {
    class Node{
        boolean end;
        Node[] next = new Node[26];
    }

    Node head = new Node();
    public WordDictionary() {
    }

    public void addWord(String word) {
        char[] letters = word.toCharArray();
        Node itr = head;
        for(char c: letters){
            if(itr.next[c - 'a'] == null){
                itr.next[c - 'a'] = new Node();
            }
            itr = itr.next[c - 'a'];
        }
        itr.end = true;
    }

    public boolean search(String word) {
        char[] letters = word.toCharArray();
        return search(head, letters, 0);
    }

    public boolean search(Node node, char[] arr, int idx){
        if(node == null){
            return false;
        }

        if(idx == arr.length){
            return node.end;
        }

        if(arr[idx] != '.'){
            return search(node.next[arr[idx] - 'a'], arr, idx + 1);
        } else {
            for(int i = 0; i < 26; ++i){
                boolean res = search(node.next[i], arr, idx + 1);
                if(res){
                    return res;
                }
            }
            return false;
        }

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */