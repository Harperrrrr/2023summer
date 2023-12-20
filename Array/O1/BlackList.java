package Array.O1;

import java.util.*;

// 710
// 有更优做法。试试只用一个blackSet
public class BlackList {
    // m black  n-m white
    private Set<Integer> black1;
    private Set<Integer> black2;
    private HashMap<Integer, Integer> black2white;
    private int n;
    private int m;
    private int idx; // 记录右端还可映射的white number
    public BlackList(int n, int[] blacklist){
        this.n = n;
        this.m = blacklist.length;
        this.idx = n - m;
        black1 = new HashSet<>();
        black2 = new HashSet<>();
        black2white = new HashMap<>();
        int whiteRange = n - m;
        for(Integer i : blacklist){
            if(i < whiteRange){
                black1.add(i);
            } else {
                black2.add(i);
            }
        }
    }

    public int pick(){
        int random = new Random().nextInt(n - m);
        if(!black1.contains(random)){
            return random;
        }
        // 选中black
        if(!black2white.containsKey(random)){
            while(black2.contains(idx)){
                idx++;
            }
            black2white.put(random, idx++);
        }
        return black2white.get(random);
    }
}
