package Structure;

import java.util.List;

public class ReplaceWords {
    class Node{
        boolean end;
        Node[] next = new Node[26];
    }

    Node head = new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        formDictionary(dictionary);

        String[] strs = sentence.split(" ");
        String ans = "";
        for(String str: strs){
            ans += replaceWord(str);
            ans += " ";
        }

        return ans.trim();
    }

    public void formDictionary(List<String> dictionary){
        for(String str: dictionary){
            addWord(str);
        }
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

    public String replaceWord(String word){
        char[] letters = word.toCharArray();
        Node itr = head;
        String res = "";

        for(char c: letters){
            if(itr.next[c - 'a'] == null){
                return word;
            }
            itr = itr.next[c - 'a'];
            res += c;
            if(itr.end){
                return res;
            }
        }

        return word;
    }
}