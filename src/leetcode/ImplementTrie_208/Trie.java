package leetcode.ImplementTrie_208;

import java.util.HashMap;
import java.util.Map;

class Trie {

    Map<String, String> map = new HashMap<>();

    public Trie() {

    }

    public void insert(String word) {
        map.put(word, word);
    }

    public boolean search(String word) {
        return map.get(word) != null;
    }

    public boolean startsWith(String prefix) {
        for(String value : map.values()) {
            if(value.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */