package Array.DiffArray;

public class FlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 5];
        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int num = booking[2];
            diff[first] += num;
            diff[last + 1] -= num;
        }
        int cur = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            ans[i] = cur;
        }
        return ans;
    }
}
