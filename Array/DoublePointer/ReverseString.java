package Array.DoublePointer;

public class ReverseString {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, j = s.length - 1; ; ++i, --j) {
            if (i == j) {
                break;
            }
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            if (i == j - 1) {
                break;
            }
        }
    }
}
