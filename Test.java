import Array.BinarySearch.SearchRange;
import Array.BinarySearch.SearchRangeBetter;
import Array.BinarySearch.ShipWithinDays;
import Array.HorseRacing;
import Array.O1.BlackList;
import Array.O1.RandomizedSet;
import Array.SlidingWindow.MinWindow;
import Array.SlidingWindow.MinWindowSimple;

public class Test {
    public static void main(String[] args) {
        BlackList bl = new BlackList(4, new int[]{0, 1});
        bl.pick();
        bl.pick();
        bl.pick();
        bl.pick();
        bl.pick();
        bl.pick();
    }
}
