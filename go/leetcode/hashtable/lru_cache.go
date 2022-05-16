package main

/**
 * @author chengzw
 * @description LRU 缓存
 * @link https://leetcode.cn/problems/lru-cache/
 * @since 2022/5/16
 */

/**
请你设计并实现一个满足 LRU(最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中， 则返回关键字的值， 否则返回 - 1。
void put(int key, int value) 如果关键字 key 已经存在， 则变更其数据值 value； 如果不存在， 则向缓存中插入该组 key - value。 如果插入操作导致关键字数量超过 capacity， 则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
*/

/**
 * 思路：哈希表 + 双向链表
 * 时间复杂度：O(1)
 * 空间复杂度：O(n), n 是 LRU 缓存容量
 */

type LRUCache struct {
	capacity   int          // 容量
	size       int          // 已使用空间
	head, tail *DLinkedNode // 头节点，尾节点
	cache      map[int]*DLinkedNode
}

type DLinkedNode struct {
	key, value int
	prev, next *DLinkedNode
}

func initDLinkedNode(key, value int) *DLinkedNode {
	return &DLinkedNode{
		key:   key,
		value: value,
	}
}

func Constructor(capacity int) LRUCache {
	l := LRUCache{
		cache:    map[int]*DLinkedNode{},
		head:     initDLinkedNode(0, 0),
		tail:     initDLinkedNode(0, 0),
		capacity: capacity,
	}
	l.head.next = l.tail
	l.tail.prev = l.head
	return l
}

func (this *LRUCache) Get(key int) int {
	// 如果没有在哈希表中找到 key
	if _, ok := this.cache[key]; !ok {
		return -1
	}
	// 如果 key 存在，先通过哈希表定位，再移到头部
	node := this.cache[key]
	this.moveToHead(node)
	return node.value
}

func (this *LRUCache) Put(key int, value int) {
	// 先去哈希表中查询
	// 如果 key 不存在，创建一个新的节点
	if node, ok := this.cache[key]; !ok {
		newNode := initDLinkedNode(key, value)
		// 如果达到容量限制，链表删除尾部节点，哈希表删除元素
		this.size++
		if this.size > this.capacity {
			// 得到删除的 key
			removed := this.removeTail()
			delete(this.cache, removed.key)
			this.size--
		}
		// 插入哈希表
		this.cache[key] = newNode
		// 插入链表
		this.addToHead(newNode)
	} else { // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
		node.value = value
		this.moveToHead(node)
	}
}

// 将节点添加到头部
func (this *LRUCache) addToHead(node *DLinkedNode) {
	// 新节点 prev 指向头节点
	node.prev = this.head
	// 新节点 next 指向原头节点的 next 节点
	node.next = this.head.next
	// 原头节点的 next 节点的 prev 指向新节点
	this.head.next.prev = node
	// 头节点 next 指向新节点
	this.head.next = node
}

// 移除节点
func (this *LRUCache) removeNode(node *DLinkedNode) {
	// 节点的 next 节点的 prev 指向节点的 prev
	node.next.prev = node.prev
	// 节点的 prev 节点的 next 指向节点的 next
	node.prev.next = node.next
}

// 移动节点到头部，先删除，再添加
func (this *LRUCache) moveToHead(node *DLinkedNode) {
	this.removeNode(node)
	this.addToHead(node)
}

// 移除尾部节点
func (this *LRUCache) removeTail() *DLinkedNode {
	node := this.tail.prev // 虚拟尾节点的上一个才是真正的尾节点
	this.removeNode(node)
	return node
}
