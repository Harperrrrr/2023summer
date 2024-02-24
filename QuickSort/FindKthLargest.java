package QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(Integer num : nums){
            list.add(num);
        }
        return quickPick(list, k);
    }

    public int quickPick(List<Integer> list, int k){
        Random rand = new Random();
        int base = list.get(rand.nextInt(list.size()));

        List<Integer> small = new ArrayList();
        List<Integer> equal = new ArrayList();
        List<Integer> big = new ArrayList();

        for(Integer num : list){
            if(num < base) {
                small.add(num);
            } else if(num > base){
                big.add(num);
            } else {
                equal.add(num);
            }
        }

        if(big.size() < k && big.size() + equal.size() >= k) {
            return base;
        } else if(big.size() >= k) {
            return quickPick(big, k);
        } else {
            return quickPick(small, k - big.size() - equal.size());
        }
    }
}
