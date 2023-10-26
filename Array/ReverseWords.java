package Array;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        trimAndReverse(sb);
        int i, j;
        for (i = 0; i < sb.length(); i = j) {
            for (j = i; j < sb.length() && sb.charAt(j) != ' '; ++j) ;
            reverse(sb, i, j - 1);
            ans.append(sb.substring(i, j));
            ans.append(' ');
            for (; j < sb.length() && sb.charAt(j) == ' '; ++j) ;
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    public void reverse(StringBuilder sb, int start, int end) {
        for (int i = start, j = end; i <= j; ++i, --j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
    }

    public void trimAndReverse(StringBuilder sb) {
        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        reverse(sb, 0, sb.length() - 1);
    }
}
