package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

import leetcode.Google_LeetCode_LRUCache.LRUResult;

public class Google_LeetCode_LRUCache_LinkedHashMap {

    static class LRUCache {
        int maxSize;
        Map<String, Integer> cache;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            cache = new LinkedHashMap<>(maxSize, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String,Integer> eldest) {
                    return size() > LRUCache.this.maxSize;
                };
            };
        }

        public void insertKeyValuePair(String key, int value) {
            cache.put(key, value);
        }

        public LRUResult getValueFromKey(String key) {
            if (cache.containsKey(key) != true) {
                return LRUResult(false, -1);
            }

            return LRUResult(true, cache.get(key));
        }

        public String getMostRecentKey() {
            if (cache.isEmpty()) {
                return null;
            }
            String mostRecentKey = "";
            for(String key : cache.keySet()) {
                mostRecentKey = key;
            }

            return mostRecentKey;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
        this.found = found;
        this.value = value;
        }
    }
    
}
