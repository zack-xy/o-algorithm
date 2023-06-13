class Deque {
  constructor() {
    this.count = 0  // 标记队列尾，用来控制队列大小
    this.lowestCount = 0  // 标记队列头，用来索引队列头
    this.items = {}
  }
  // 在前端添加新元素


  // 检查队列是否为空
  isEmpty () {
    return this.count - this.lowestCount === 0
  }
  // 清空队列
  clear () {
    this.items = {}
    this.count = 0
    this.lowestCount = 0
  }
  // 返回队列大小
  size () {
    return this.count - this.lowestCount
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


  // 在队列前端添加新的元素
  addFront (element) {
    if (this.isEmpty()) {
      this.addBack(element)
    } else if (this.lowestCount > 0) {
      this.lowestCount--
      this.items[this.lowestCount] = element
    } else {
      for (let i = this.count; i > 0; i--) {
        this.items[i] = this.items[i - 1]
      }
      this.count++
      this.items[0] = element
    }
  }


  // 在队列后端添加新的元素
  addBack (element) {
    this.items[this.count] = element
    this.count++
  }


  // 从队列前端移除第一个元素并返回
  removeFront () {
    if (this.isEmpty()) {
      return undefined
    }
    const result = this.items[this.lowestCount]
    delete this.items[this.lowestCount]
    this.lowestCount++
    return result
  }


  // 从队列后端移除第一个元素并返回
  removeBack () {
    if (this.isEmpty()) {
      return undefined;
    }
    this.count--;
    const result = this.items[this.count];
    delete this.items[this.count];
    return result;
  }


  // 返回前端第一个元素
  peekFront () {
    if (this.isEmpty()) {
      return undefined
    }
    return this.items[this.lowestCount]
  }


  // 返回后端第一个元素
  peekBack () {
    if (this.isEmpty()) {
      return undefined
    }
    return this.items[this.count - 1]
  }
}





