// 双向链表节点
class Node {
  constructor(val) {
    this.val = val
    this.next = null
    this.pre = null
  }

  insertPre(node) {
    node.pre = this.pre
    node.next = this
    if (this.pre)
      this.pre.next = node
    this.pre = node
  }

  insertNext(node) {
    node.pre = this
    node.next = this.next
    if (this.next)
      this.next.pre = node
    this.next = node
  }

  deletePre() {
    if (this.pre) {
      this.pre.pre && (this.pre.pre.next = this)
      this.pre = this.pre.pre
    }
  }

  deleteNext() {
    if (this.next) {
      this.next.next && (this.next.next.pre = this)
      this.next = this.next.next
    }
  }
}

// 双端队列
class DoubleQueue {
  constructor() {
    this.head = new Node(0) // 虚拟头
    this.tail = new Node(0) // 虚拟尾
    this.count = 0 // 队列的数量
    this.head.next = this.tail
    this.head.pre = null
    this.tail.next = null
    this.tail.pre = this.head
  }

  pushBack(val) {
    this.tail.insertPre(new Node(val))
    this.count += 1
  }

  pushFront(val) {
    this.head.insertNext(new Node(val))
    this.count += 1
  }

  popBack() {
    if (this.isEmpty())
      return
    const ret = this.tail.pre.val
    this.tail.deletePre()
    this.count -= 1
    return ret
  }

  popFront() {
    if (this.isEmpty())
      return
    const ret = this.head.next.val
    this.head.deleteNext()
    this.count -= 1
    return ret
  }

  front() {
    return this.head.next.val
  }

  back() {
    return this.tail.pre.val
  }

  isEmpty() {
    return this.head.next === this.tail
  }

  size() {
    return this.count
  }
}

const FrontMiddleBackQueue = function () {
  this.q1 = new DoubleQueue()
  this.q2 = new DoubleQueue()
}

/**
 * @param {number} val
 * @return {void}
 */
FrontMiddleBackQueue.prototype.pushFront = function (val) {
  this.q1.pushFront(val)
  this.update()
}

/**
 * @param {number} val
 * @return {void}
 */
FrontMiddleBackQueue.prototype.pushMiddle = function (val) {
  if (this.q1.size() > this.q2.size()) {
    this.q2.pushFront(this.q1.back())
    this.q1.popBack()
  }
  this.q1.pushBack(val)
}

/**
 * @param {number} val
 * @return {void}
 */
FrontMiddleBackQueue.prototype.pushBack = function (val) {
  this.q2.pushBack(val)
  this.update()
}

/**
 * @return {number}
 */
FrontMiddleBackQueue.prototype.popFront = function () {
  if (this.isEmpty())
    return -1
  const popVal = this.q1.popFront()
  this.update()
  return popVal
}

/**
 * @return {number}
 */
FrontMiddleBackQueue.prototype.popMiddle = function () {
  if (this.isEmpty())
    return -1
  const ret = this.q1.popBack()
  this.update()
  return ret
}

/**
 * @return {number}
 */
FrontMiddleBackQueue.prototype.popBack = function () {
  if (this.isEmpty())
    return -1
  let popVal
  if (this.q2.isEmpty())
    popVal = this.q1.popBack()

  else
    popVal = this.q2.popBack()

  this.update()
  return popVal
}

FrontMiddleBackQueue.prototype.update = function () {
  // q1的元素不少于q2
  if (this.q1.size() < this.q2.size()) {
    this.q1.pushBack(this.q2.front())
    this.q2.popFront()
  }
  if (this.q1.size() >= this.q2.size() + 2) {
    this.q2.pushFront(this.q1.back())
    this.q1.popBack()
  }
}

FrontMiddleBackQueue.prototype.isEmpty = function () {
  return this.q1.size() + this.q2.size() === 0
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * var obj = new FrontMiddleBackQueue()
 * obj.pushFront(val)
 * obj.pushMiddle(val)
 * obj.pushBack(val)
 * var param_4 = obj.popFront()
 * var param_5 = obj.popMiddle()
 * var param_6 = obj.popBack()
 */
