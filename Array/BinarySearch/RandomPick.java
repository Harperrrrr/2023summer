package Array.BinarySearch;

public class RandomPick {
    public int[] sum;

    public RandomPick(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            sum[i] = sum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int num = (int) (Math.random() * sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        /**
         * 找比num大的最左边一个
         */
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (sum[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
