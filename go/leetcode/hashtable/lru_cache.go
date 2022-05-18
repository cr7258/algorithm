package main

import "fmt"

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

// LRU 数据结构
type LRUCache struct {
	capacity   int                  // 容量
	size       int                  // 已使用空间
	head, tail *DLinkedNode         // 头节点，尾节点
	cache      map[int]*DLinkedNode // 哈希表
}

// 双向链表数据结构
type DLinkedNode struct {
	key, value int
	prev, next *DLinkedNode // 前指针，后指针
}

// 创建一个新的节点
func initDLinkedNode(key, value int) *DLinkedNode {
	return &DLinkedNode{
		key:   key,
		value: value,
	}
}

// 初始化 LRU 结构
func Constructor(capacity int) LRUCache {
	l := LRUCache{
		cache:    map[int]*DLinkedNode{}, //  哈希表
		head:     initDLinkedNode(0, 0),  // 虚拟头节点
		tail:     initDLinkedNode(0, 0),  // 虚拟尾节点
		capacity: capacity,               // 容量
	}
	// 虚拟头节点和虚拟尾节点互连
	l.head.next = l.tail
	l.tail.prev = l.head
	return l
}

// 获取元素
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

// 插入元素
func (this *LRUCache) Put(key int, value int) {
	// 先去哈希表中查询
	// 如果 key 不存在，创建一个新的节点
	if node, ok := this.cache[key]; !ok {
		newNode := initDLinkedNode(key, value)
		// 如果达到容量限制，链表删除尾部节点，哈希表删除元素
		this.size++
		if this.size > this.capacity {
			// 得到删除的节点
			removed := this.removeTail()
			// 根据得到的 key 删除哈希表中的元素
			delete(this.cache, removed.key)
			// 减少已使用容量
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
	// 新节点指向前后节点
	node.prev = this.head
	node.next = this.head.next

	// 前后节点指向新节点
	this.head.next.prev = node
	this.head.next = node
}

// 删除该节点
func (this *LRUCache) removeNode(node *DLinkedNode) {
	// 修改该节点前后节点的指针，不再指向该节点
	node.next.prev = node.prev
	node.prev.next = node.next
}

// 移动到头部，也就是当前位置删除，再添加到头部
func (this *LRUCache) moveToHead(node *DLinkedNode) {
	this.removeNode(node)
	this.addToHead(node)
}

// 移除尾部节点，淘汰最久未使用的
func (this *LRUCache) removeTail() *DLinkedNode {
	node := this.tail.prev // 虚拟尾节点的上一个才是真正的尾节点
	this.removeNode(node)
	return node
}

// 打印链表（解题不需要此方法，只是为了显示效果）
func (this *LRUCache) printDLinkedNode() {
	p := this.head
	for p != nil {
		fmt.Printf("key: %d, value: %d\n", p.key, p.value)
		p = p.next
	}
}
func main() {
	lru := Constructor(3)
	fmt.Println("=========================== 插入 3 个节点 ===========================")
	lru.Put(1, 100)
	lru.Put(2, 200)
	lru.Put(3, 300)
	fmt.Println("=========================== 打印当前链表 ===========================")
	lru.printDLinkedNode()

	fmt.Println("=========================== 插入第 4 个节点，LRU 缓存淘汰尾部节点 ===========================")
	lru.Put(4, 400)
	lru.printDLinkedNode()

	fmt.Println("=========================== 获取 key2 节点，更新 LRU 缓存，将会移动至链表头部 ===========================")
	lru.Get(2)
	lru.printDLinkedNode()
}
