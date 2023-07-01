import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {//354
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int[] dp = new int[envelopes.length + 1];
        int cur_len = 0;
        dp[0] = -1;
        for (int i = 0; i < envelopes.length; ++i) {
            if (envelopes[i][1] > dp[cur_len]) {
                dp[++cur_len] = envelopes[i][1];
            } else {
                int idx = binarySearch(dp, envelopes[i][1], cur_len);
                //find the first that >= envelopes[i][1]
                dp[idx] = envelopes[i][1];
            }
        }
        return cur_len;
    }

    public static int binarySearch(int[] dp, int num, int len) {
        int low = 0;
        int high = len;
        while (low < high) {
            int mid = (low + high) / 2;
            if (num > dp[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args){
        int[][] envelopes = {{15,8},{2,20},{2,14},{4,17},{8,19},{8,9},{5,7},{11,19},{8,11},{13,11},{2,13},{11,19},{8,11},{13,11},{2,13},{11,19},{16,1},{18,13},{14,17},{18,19}};
        maxEnvelopes(envelopes);
    }
}
