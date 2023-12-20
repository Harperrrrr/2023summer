package Array.BinarySearch;

public class EatingBananas {
    // 875

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (Integer i : piles) {
            if (i > right) {
                right = i;
            }
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            int time = hourToEat(piles, mid);
            if(time > h){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }


    // 给定每小时能吃的香蕉数，返回需要吃的时间
    public int hourToEat(int[] piles, int speed) {
        int hours = 0;
        for (Integer i : piles) {
            hours += i % speed == 0 ? i / speed : i / speed + 1;
        }
        return hours;
    }

}
