package leetcode.hashtable;

/**
 * @author chengzw
 * @description LRU 缓存
 * @link https://leetcode.cn/problems/lru-cache/
 * @since 2022/5/16
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足 LRU(最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中， 则返回关键字的值， 否则返回 - 1。
 * void put(int key, int value) 如果关键字 key 已经存在， 则变更其数据值 value； 如果不存在， 则向缓存中插入该组 key - value。 如果插入操作导致关键字数量超过 capacity， 则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */

/**
 * 思路：哈希表 + 双向链表
 * 时间复杂度：O(1)
 * 空间复杂度：O(n), n 是 LRU 缓存容量
 */
public class LRUCache {
    // 双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 哈希表
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    // 已使用空间
    private int size;
    // 容量
    private int capacity;
    // 头节点，尾节点
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用虚拟头部和虚拟尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 虚拟头节点和虚拟尾节点互连
        head.next = tail;
        tail.prev = head;
    }

    // 获取元素
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        // 如果没有在哈希表中找到 key
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    // 插入元素
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 如果达到容量限制，链表删除尾部节点，哈希表删除元素
            size++;
            if (size > capacity) {
                // 得到删除的节点
                DLinkedNode removed = removeTail();
                // 根据得到的 key 删除哈希表中的元素
                cache.remove(removed.key);
                // 减少已使用容量
                size--;
            }
            // 插入哈希表
            cache.put(key, newNode);
            // 添加至双链表的头部
            addToHead(newNode);
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 将节点添加到链表头部
    private void addToHead(DLinkedNode node) {
        // 新节点指向前后节点
        node.prev = head;
        node.next = head.next;
        // 前后节点指向新节点
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(DLinkedNode node) {
        // 修改该节点前后节点的指针，不再指向该节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移动到头部，也就是当前位置删除，再添加到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 移除尾部节点，淘汰最久未使用的
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev; // 虚拟尾节点，prev 才是此时真正的尾节点
        removeNode(res);
        return res;
    }

    // 打印链表（解题不需要此方法，只是为了显示效果）
    private void printDLinkedNode() {
        DLinkedNode p = this.head;
        while (p != null) {
            System.out.printf("key: %d, value: %d\n", p.key, p.value);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        System.out.println("=========================== 插入 3 个节点 ===========================");
        lru.put(1, 100);
        lru.put(2, 200);
        lru.put(3, 300);
        System.out.println("=========================== 打印当前链表 ===========================");
        lru.printDLinkedNode();

        System.out.println("=========================== 插入第 4 个节点，LRU 缓存淘汰尾部节点 key1 ===========================");
        lru.put(4, 400);
        lru.printDLinkedNode();

        System.out.println("=========================== 获取 key2 的节点，更新 LRU 缓存，将会移动至链表头部 ===========================");
        lru.get(2);
        lru.printDLinkedNode();
    }
}
