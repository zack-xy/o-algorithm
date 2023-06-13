export default class Stack {
  constructor() {
    this.count = 0  // 表示栈的大小
    this.items = {}  // key:count,value:值,key从0开始
  }

  //返回栈的大小
  size () {
    return this.count
  }

  // 判断栈是否为空
  isEmpty () {
    return this.count === 0
  }

  // 移除栈中元素，返回移除的元素
  pop () {
    if (this.isEmpty()) {
      return undefined
    }
    this.count--
    const result = this.items[this.count]
    delete this.items[this.count]
    return result
  }

  // 返回栈顶元素（不修改栈）
  peek () {
    if (this.isEmpty()) {
      return undefined
    }
    return this.items[this.count - 1]
  }

  // 清空栈
  clear () {
    this.items = []
    this.count = 0
  }

  // 打印栈内容
  toString () {
    if (this.isEmpty()) {
      return ''
    }
    let objString = `${this.items[0]}`
    for (let i = 1; i < this.count; i++) {
      objString = `${objString},${this.items[i]}`
    }
    return objString
  }
}