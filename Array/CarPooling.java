package Array;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1005];
        for (int[] trip : trips) {
            int num = trip[0];
            int start = trip[1];
            int end = trip[2];
            diff[start] += num;
            diff[end] -= num;
        }
        int cur = 0;
        for (Integer i : diff) {
            cur += i;
            if(cur > capacity){
                return false;
            }
        }
        return true;
    }
}
