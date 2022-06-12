class Stack {
  constructor() {
    this.items = []
  }

  // push(element(s)): 添加1个(几个)新元素到栈顶
  push (element) {
    this.items.push(element)
  }
  // pop():移除栈顶元素，同时返回被移除的元素
  pop () {
    return this.items.pop()
  }
  // peek():返回栈顶元素(不修改栈)
  peek () {
    return this.items[this.items.length - 1]
  }
  // clear():移除栈里所有元素
  clear () {
    this.items = []
  }
  // size():返回栈里元素个数
  size () {
    return this.items.length
  }
  // isEmpty():检查栈是否为空
  isEmpty () {
    return this.items.length === 0
  }
}