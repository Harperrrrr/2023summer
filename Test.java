import Structure.LFUCache;
import Structure.LRUCache;
import Structure.ReplaceWords;
import Structure.WordDictionary;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("rat");
        dictionary.add("bat");

        String sentence = "the cattle was rattled by the battery";

        rw.replaceWords(dictionary, sentence);
    }
}
