export function defaultEquals (a, b) {
  return a === b;
}

export class Node {
  constructor(element, next) {
    this.element = element;
    this.next = next;
  }
}

export default class LinkedList {
  constructor(equalsFn = defaultEquals) {
    this.count = 0
    this.head = undefined
    this.equalsFn = equalsFn
  }

  // 向链表尾部添加一个新元素
  push (element) {
    const node = new Node(element)
    let current
    if (this.head == null) {
      this.head = node
    } else {
      current = this.head
      while (current.next != null) {
        current = current.next
      }
      current.next = node
    }
    this.count++
  }

  // 向链表特定位置插入一个新元素
  insert (element, index) {
    if (index >= 0 && index <= this.count) {
      const node = new Node(element)
      if (index === 0) {
        const current = this.head
        node.next = current
        this.head = node
      } else {
        const previous = this.getElementAt(index - 1)
        const current = previous.next
        node.next = current
        previous.next = node
      }
      this.count++
      return true
    }
    return false
  }

  // 获取指定位置元素
  getElementAt (index) {
    if (index >= 0 && index <= this.count) {
      let node = this.head
      for (let i = 0; i < index && node != null; i++) {
        node = node.next
      }
      return node
    }
    return undefined
  }

  // 从链表中移除一个元素
  remove (element) {
    const index = this.indexOf(element)
    return this.removeAt(index)
  }

  // 返回元素在链表中的索引，如果没有该元素返回-1
  indexOf (element) {
    let current = this.head
    for (let i = 0; i < this.count && current != null; i++) {
      if (this.equalsFn(element, current.element)) {
        return i
      }
      current = current.next
    }
    return -1
  }


  //移除链表特定位置元素
  removeAt (index) {
    // 检查越界值
    if (index >= 0 && index < this.count) {
      let current = this.head


      // 移除第一项
      if (index === 0) {
        this.head = current.next
      } else {
        const previous = this.getElementAt(index - 1)
        current = previous.next
        previous.next = current.next
      }
      this.count--
      return current.element
    }
    return undefined
  }

  // 判断链表是否为空
  isEmpty () {
    return this.size() === 0
  }

  // 返回链表包含的元素个数
  size () {
    return this.count
  }


  // 获取链表头
  getHead () {
    return this.head
  }


  // 清空链表
  clear () {
    this.head = undefined
    this.count = 0
  }

  // 返回表示链表的整个字符串
  toString () {
    if (this.head == null) {
      return ''
    }
    let objString = `${this.head.element}`
    let current = this.head.next
    for (let i = 1; i < this.size() && current != null; i++) {
      objString = `${objString},${current.element}`
      current = current.next
    }
    return objString
  }
}