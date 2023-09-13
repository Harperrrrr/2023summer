public class RingAndPole {
    public int countPoints(String rings) {
        int poles[] = new int[10];
        for (int i = 0; i < rings.length() - 1; i += 2) {
            int idx = Integer.parseInt(String.valueOf(rings.charAt(i + 1)));
            char ch = rings.charAt(i);
            if (ch == 'R') {
                poles[idx] |= 1;
            } else if (ch == 'G') {
                poles[idx] |= 2;
            } else if (ch == 'B') {
                poles[idx] |= 4;
            }
        }
        int ans = 0;
        for (Integer i : poles) {
            if (i == 7) ans++;
        }
        return ans;
    }
}
