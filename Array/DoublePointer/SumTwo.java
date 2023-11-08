package Array.DoublePointer;

public class SumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int tmp = 0;
        while (i < j) {
            tmp = numbers[i] + numbers[j];
            if (tmp < target) {
                i++;
            } else if (tmp > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1,-1};
    }
}
