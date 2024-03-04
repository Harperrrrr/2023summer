import Array.Manacher;
import Array.MyManacher;
import DP.DifferentSubsequence;
import DP.MinFallingPath;
import Structure.LFUCache;
import Structure.LRUCache;
import Structure.ReplaceWords;
import Structure.WordDictionary;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        DifferentSubsequence ds = new DifferentSubsequence();
        ds.numDistinct("babgbag", "bag");
    }
}
