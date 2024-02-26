package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

class LRUCash {

    private final Map<Integer, Integer> map;

    private final LinkedList<Integer> queue;

    private final int capacity;

    public LRUCash(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));


    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        IntStream.range(0, nums.length).forEach(i -> map.put(nums[i], i));

        int d = 0;

        for (int i = 1; i < nums.length; i++) {
            d = target - nums[i];

            if (map.containsKey(d)) {
                return new int[]{i, map.get(d)};
            }

        }
        return null;
    }



    static class LRUCacheS {
        private final LinkedHashMap<Integer, Integer> map;
        private final int SIZE;

        public LRUCacheS(int size) {
            this.SIZE = size;
            this.map = new LinkedHashMap<>(size, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() >= SIZE;
                }
            };
        }

        public void put(int key, int value) {

            //1.
            if (map.containsKey(key)) {
                //2.1 known element
                map.remove(key);

            } else if (map.size() == SIZE) {
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }

            map.put(key, value);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.remove(key);
                map.put(key, value);

                return value;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "LRUCacheS{" +
                    "map=" + map +
                    ", SIZE=" + SIZE +
                    '}';
        }
    }


}
