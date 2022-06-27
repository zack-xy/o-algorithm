// 普通队列一种实现
class Queue {
  constructor(size) {
    this.head = 0
    this.tail = 0
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
  }

  // 出队
  pop() {
    if (this.empty())
      return
    this.head += 1
  }

  // 判空
  empty() {
    return this.head === this.tail
  }

  // 判断是否满
  full() {
    return this.tail === this._arr.length
  }

  // 查看队首操作
  front() {
    return this._arr[this.head]
  }

  // 队列元素数量
  size() {
    return this.tail - this.head
  }

  // 输出队列元素
  output() {
    let str = ''
    for (let i = this.head; i < this.tail; i++)
      str += `${this._arr[i]}|`

    return str
  }
}
