/**
 * Initialize your data structure here.
 */
const MyQueue = function () {
  this.s1 = [] // 出队列使用
  this.s2 = [] // 入队列使用
}

/**
 * Push element x to the back of queue.
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.s2.push(x)
}

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  this.transfer()
  const ret = this.s1.pop()
  return ret
}

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  this.transfer()
  const ret = this.s1[this.s1.length - 1]
  return ret
}

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return this.s1.length === 0 && this.s2.length === 0
}

MyQueue.prototype.transfer = function () {
  if (this.s1.length > 0)
    return
  while (this.s2.length > 0)
    this.s1.push(this.s2.pop())
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
