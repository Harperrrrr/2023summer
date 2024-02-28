import Structure.LFUCache;
import Structure.LRUCache;

public class Test {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);

    }
}
