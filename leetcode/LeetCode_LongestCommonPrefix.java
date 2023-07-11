package leetcode;

public class Solution {
    // public String longestCommonPrefix(String[] strs) {
    //     // 1. horizontal search 
    //     String prefix = strs[0];

    //     int size = strs.length; 
    //     for(int idx = 1; idx < size; idx++) {
    //         while(strs[idx].indexOf(prefix) != 0) {
    //             prefix = prefix.substring(0, prefix.length() - 1);
    //             if(prefix.isEmpty() || prefix.isBlank()) return "";
    //         }
    //     }

    //     return prefix;
    // }

    // public String longestCommonPrefix(String[] strs) {
    //     // 2. divde and conquer

    //     if(strs.length == 0) return "";

    //     return longestCommonPrefix(0, strs.length - 1, strs);
    // }

    // private String longestCommonPrefix(int start, int end, String[] strs) {
    //     if(start == end) return strs[start];


    //     int mid = (start + end) / 2;

    //     String lcpLeft = longestCommonPrefix(start, mid, strs);
    //     String lcpRight = longestCommonPrefix(mid+1, end, strs);
    //     return commonPrefix(lcpLeft, lcpRight); 
    // }

    // private String commonPrefix(String left, String right) {
    //     int leftLength = left.length(), rightLength = right.length();

    //     int minLength = Math.min(leftLength, rightLength);

    //     StringBuilder prefix = new StringBuilder("");

    //     for(int idx = 0; idx < minLength; idx++) {
    //         if(left.charAt(idx) != right.charAt(idx)) return prefix.toString();
    //         if(minLength == leftLength) prefix.append(left.charAt(idx));
    //         else prefix.append(right.charAt(idx));
    //     }

    //     return prefix.toString();
    // }

    // public String longestCommonPrefix(String[] strs) {
    //     // 3. binary search

    //     int minPrefixLength = Integer.MAX_VALUE;

    //     for(String str : strs) {
    //         minPrefixLength = Math.min(minPrefixLength, str.length());
    //     }

    //     int left = 0, right = minPrefixLength;

    //     while(left <= right) {
    //         int mid = (left + right) / 2;

    //         if(isCommonPrefix(strs, mid)){
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }

    //     return strs[0].substring(0, (left + right) / 2);
    // }


    // private boolean isCommonPrefix(String[] str, int length) {
    //     String str0Prefix = str[0].substring(0, length);

    //     for(int idx = 1; idx < str.length; idx++) {
    //         if(!str0Prefix.equals(str[idx].substring(0, length))) return false;            
    //     }

    //     return true;
    // }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private int size;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public void put(char value, TrieNode node) {
            links[value - 'a'] = node;
            size++;
        }

        public int size() {
            return size;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for(int idx = 0; idx < word.length(); idx++) {
                char currentWord = word.charAt(idx);

                if(!node.containsKey(currentWord)) {
                    node.put(currentWord, new TrieNode());
                }
                node = node.get(currentWord);
            }

            node.setEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;

            for(int idx = 0; idx < word.length(); idx++) {
                if(!node.containsKey(word.charAt(idx))) {
                    return null;
                }

                node = node.get(word.charAt(idx));
            }

            return node;
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public String searchLongestPrefix(String word) {
            TrieNode node = root;

            StringBuilder prefix = new StringBuilder();

            for(int idx = 0; idx < word.length(); idx++) {
                char currentWord = word.charAt(idx);

                if(node.containsKey(currentWord) && node.size() == 1 && !node.isEnd()) {
                    prefix.append(currentWord);
                    node = node.get(currentWord);
                } else {
                    return prefix.toString();
                }
            }

            return prefix.toString();
        }
    }

    public String longestCommonPrefix(String[] strs) {

        // 4. Using Trie
        Trie trie = new Trie();

        if(strs == null || strs.length == 0) return "";

        if(strs.length == 1) return strs[0];

        for(String str : strs) {
            trie.insert(str);
        }

        return trie.searchLongestPrefix(strs[0]);
    }
}
