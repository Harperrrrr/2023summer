package Array.O1;

import java.util.HashMap;
import java.util.Random;

// 380
public class RandomizedSet {
    private int size;
    private int[] array;
    private HashMap<Integer, Integer> map;

    public RandomizedSet() {
        size = 0;
        array = new int[200005];
        // key : val    value : 数组中idx
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, size);
            array[size++] = val;
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int idx = map.remove(val);
            int last = array[--size];
            if(last != val){
                array[idx] = last;
                map.put(last, idx);
            }
            return true;
        }
    }

    public int getRandom() {
        int idx = (int) (new Random().nextInt(size));
        return array[idx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
