package Array.BinarySearch;

public class ShipWithinDays {
    // 1011
    public int shipWithinDays(int[] weights, int days) {
        int min = 0; //货物的最大weight
        int max = 0;
        for (Integer i : weights) {
            max += i;
            min = Math.max(i, min);
        }
        int mid = 0;
        boolean able;
        while (min < max) {
            mid = (min + max) / 2;
            able = ableToShip(weights, days, mid);
            if (able) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean ableToShip(int[] weights, int days, int capacity) {
        // [1,2,3,4,5,6,7,8,9,10]
        int cur = 0;
        for (Integer i : weights) {
            cur += i;
            if (cur > capacity) {
                days--;
                cur = i;
            }
            if (days <= 0) {
                return false;
            }
        }
        return true;
    }
}
