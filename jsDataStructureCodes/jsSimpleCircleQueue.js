// 循环队列一种实现
class CircleQueue {
  constructor(size) {
    this.head = 0
    this.tail = 0
    this.size = 0
    this._arr = new Array(size)
  }

  // 入队
  push(item) {
    if (this.full()) {
      console.log('queue full')
      return
    }
    this._arr[this.tail] = item
    this.tail += 1
    this.size += 1
    if (this.tail === this._arr.length)
      this.tail = 0
  }

  // 出队
  pop() {
    if (this.empty())
      return
    this.head += 1
    this.size -= 1
    if (this.head === this._arr.length)
      this.head = 0
  }

  // 判空
  empty() {
    return this.size === 0
  }

  // 判断是否满
  full() {
    return this.size === this._arr.length
  }

  // 查看队首操作
  front() {
    return this._arr[this.head]
  }

  // 队列元素数量
  size() {
    return this.size
  }

  clear() {
    this.head = this.tail = this.size = 0
  }

  // 输出队列元素
  output() {
    let str = ''
    for (let i = 0, j = this.head; i < this.size; i++) {
      str += `${this._arr[j]}|`
      j += 1
      if (j === this._arr.length)
        j = 0
    }
    return str
  }
}
