package Array.BinarySearch;

public class ShipWithinDaysBetter {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (Integer i : weights) {
            right += i;
            if (i > left) {
                left = i;
            }
        }

        while (left < right) {
            int mid = (left + right) >> 1;
            int ds = daysToShip(weights, mid);
            if (ds > days){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;

    }

    // 给定船的承重能力，返回需要花费的天数
    public int daysToShip(int[] weights, int capacity) {
        int days = 0;
        int cur = 0;
        for (Integer i : weights) {
            cur += i;
            if (cur > capacity) {
                days++;
                cur = i;
            }
        }
        return days + 1;
    }
}
