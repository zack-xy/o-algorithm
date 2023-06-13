/*
 * @lc app=leetcode.cn id=146 lang=javascript
 *
 * [146] LRU 缓存
 */

// @lc code=start
/**
 * @param {number} capacity
 */

// 使用js自带的数据结构Map
// 因为js中的Map是有插入顺序的
// Java的HashMap没有插入顺序，就需要其他数据结构（双向链表）辅助
var LRUCache = function(capacity) {
  this.cache = new Map()
  this.max = capacity
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
  if(this.cache.has(key )) {
    let temp = this.cache.get(key)
    this.cache.delete(key)
    this.cache.set(key, temp)
    return temp
  }
  return -1
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
  if(this.cache.has(key)) {
    this.cache.delete(key)  // 已有，删除再重新赋值，以标识最近使用
  } else if(this.cache.size>=this.max ){ // 超出最大的缓存，需要删除某项
    this.cache.delete(this.cache.keys().next().value) // 最不经常使用的，在map第一个，需要淘汰
  }
  this.cache.set(key, value)   // 把最常使用的放在map最后
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
// @lc code=end

