package Array.O1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlackListBetter {
    private int n;
    private int m;
    private int idx;
    private HashMap<Integer, Integer> black2white;
    private Set<Integer> black2;
    public BlackListBetter(int n, int[] blacklist){
        this.n = n;
        this.m = blacklist.length;
        this.idx = n - m;
        this.black2white = new HashMap<>();
        this.black2 = new HashSet<>();
        for(Integer i: blacklist){
            if(i >= idx){
                black2.add(i);
            }
        }
        for(Integer i: blacklist){
            if(i < n - m){
                while(black2.contains(idx)){
                    idx++;
                }
                black2white.put(i, idx++);
            }
        }
    }

    public int pick(){
        int random = new Random().nextInt(n-m);
        return black2white.getOrDefault(random, random);
    }
}
