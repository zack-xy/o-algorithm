class Queue {
  constructor() {
    this.count = 0
    this.lowestCount = 0
    this.items = {}
  }


  // 向队列尾部添加一个新的项
  enqueue (element) {
    this.items[this.count] = element
    this.count++
  }
  // 移除队列的第一项,返回被移除的元素
  dequeue () {
    if (this.isEmpty()) {
      return undefined
    }
    const result = this.items[this.lowestCount]
    delete this.items[this.lowestCount]
    this.lowestCount++
    return result
  }
  // 返回队列中的第一个元素，不改变队列
  peek () {
    if (this.isEmpty()) {
      return undefined
    }
    return this.items[this.lowestCount]
  }
  // 判断队列是否为空
  isEmpty () {
    return this.count - this.lowestCount === 0
  }
  // 返回队列长度
  size () {
    return this.count - this.lowestCount
  }
  // 清空队列
  clear () {
    this.items = {}
    this.count = 0
    this.lowestCount = 0
  }
  // 转为字符串
  toString () {
    if (this.isEmpty()) {
      return ''
    }
    let objString = `${this.items[this.lowestCount]}`
    for (let i = this.lowestCount + 1; i < this.count; i++) {
      objString = `${objString},${this.items[i]}`
    }
    return objString
  }
}