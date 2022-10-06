package leetcode.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode208.java
 * Description:
 *
 * @author Peng Shiquan
 * @date 2022/10/6
 */
public class LeetCode208 {
    public static void main(String[] args) {

    }

}

class Trie {
    Set<String> trie;

    public Trie() {
        trie = new HashSet<>();
    }

    public void insert(String word) {
        trie.add(word);
    }

    public boolean search(String word) {
        return trie.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : trie) {
            if (s.startsWith(prefix)) return true;
        }
        return false;
    }
}

class Trie2 {
    private Trie2[] children;
    private boolean isEnd;

    public Trie2() {
        //代表26个字母
        children = new Trie2[26];
        isEnd = false;
    }

    public void insert(String word) {
        //从跟节点开始找
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie2();
            }
            node = children[index];
        }
        //修改最后一个节点为结束字母
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie2 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie2 node = searchPrefix(prefix);
        return node != null;
    }

    public Trie2 searchPrefix(String prefix) {
        Trie2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
