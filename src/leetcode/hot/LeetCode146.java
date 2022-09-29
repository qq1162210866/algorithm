package leetcode.hot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode146.java
 * Description: https://leetcode.cn/problems/lru-cache/?favorite=2cktkvj
 *
 * @author Peng Shiquan
 * @date 2022/9/29
 */
public class LeetCode146 {
}

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private Integer capacity;

    //以 正整数 作为容量 capacity 初始化 LRU 缓存
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    //如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
    // 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
