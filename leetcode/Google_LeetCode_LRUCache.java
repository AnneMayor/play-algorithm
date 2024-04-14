package leetcode;

import java.util.HashMap;
import java.util.Map;

// Tip: We can use multiple data structures
public class Google_LeetCode_LRUCache {
    static class LRUCache {
        int maxSize;
        private Map<String, DoublyLinkedListNode> cache;
        DoublyLinkedList listOfMostRecent;
        int currentSize;
    
        public LRUCache(int maxSize) {
            this.cache = new HashMap<>();
            listOfMostRecent = new DoublyLinkedList();
            this.maxSize = maxSize > 1 ? maxSize : 1;
            this.currentSize = 0;
        }
    
        public void insertKeyValuePair(String key, int value) {
            if (cache.containsKey(key) != true) {
                if (currentSize == maxSize) {
                    evictLeastRecent();
                } else {
                    currentSize++;
                }
                cache.put(key, new DoublyLinkedListNode(key, value));
            } else {
                replaceKey(key, value);
            }
            updateMostRecent(cache.get(key));
        }

        private void evictLeastRecent() {
            String keyToRemove = listOfMostRecent.tail.key;
            listOfMostRecent.removeTail();
            cache.remove(keyToRemove);
        }

        private void replaceKey(String key, int value) {
            if (cache.containsKey(key) != true) {
                return;
            }
            cache.get(key).value = value;
        }

        private void updateMostRecent(DoublyLinkedListNode node) {
            listOfMostRecent.setHeadTo(node);
        }
    
        public LRUResult getValueFromKey(String key) {
          if (cache.containsKey(key) != true) {
            return new LRUResult(false, -1);
          }
          updateMostRecent(cache.get(key));
          return new LRUResult(true, cache.get(key).value);
        }
    
        public String getMostRecentKey() {
            if (listOfMostRecent.head == null) {
                return "";
            }
            
            return listOfMostRecent.head.key;
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

    static class DoublyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;

        public void setHeadTo(DoublyLinkedListNode node) {
            if (head == node) return;
            else if (head == null) {
                head = node;
                tail = node;
            }

            else if (head == tail) {
                tail.prev = node;
                head = node;
                head.next = tail;
            }

            else {
                if (tail == node) {
                    removeTail();
                }

                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        public void removeTail() {
            if (tail == null) return;
            if (tail == head) {
                head = null;
                tail = null;
                return;
            }

            tail = tail.prev;
            tail.next = null;
        }
    }

    static class DoublyLinkedListNode {
        String key;
        int value;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;

        public DoublyLinkedListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }
            prev = null;
            next = null;
        }
    }
}
