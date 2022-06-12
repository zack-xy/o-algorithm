import { Node, defaultEquals } from './jsLinkedList'
import LinkedList from './jsLinkedList';


export class DoublyNode extends Node {
  constructor(element, next, prev) {
    super(element, next)
    this.prev = prev
  }
}


export default class DoublyLinkedList extends LinkedList {
  constructor(equalsFn = defaultEquals) {
    super(equalsFn)
    this.tail = undefined
  }


  // 向链表尾部添加一个新元素
  push (element) {
    const node = new DoublyNode(element)
    if (this.head == null) {
      this.head = node
      this.tail = node
    } else {
      this.tail.next = node
      node.prev = this.tail
      this.tail = node
    }
    this.count++
  }


  // 在任意位置插入新元素
  insert (element, index) {
    if (index >= 0 && index <= this.count) {
      const node = new DoublyNode(element)
      let current = this.head
      if (index === 0) {
        if (this.head == null) {
          this.head = node
          this.tail = node
        } else {
          node.next = this.head
          current.prev = node
          this.head = node
        }
      } else if (index === this.count) {
        current = this.tail
        current.next = node
        node.prev = current
        this.tail = node
      } else {
        const previous = this.getElementAt(index - 1)
        current = previous.next
        node.next = current
        previous.next = node
        current.prev = node
        node.prev = previous
      }
      this.count++
      return true
    }
    return false
  }


  // 从任意位置移除元素
  removeAt (index) {
    if (index >= 0 && index < this.count) {
      let current = this.head
      if (index === 0) {
        this.head = current.next
        if (this.count === 1) {
          this.tail = undefined
        } else {
          this.head.prev = undefined
        }
      } else if (index === this.count - 1) {
        current = this.tail
        this.tail = current.prev
        this.tail.next = undefined
      } else {
        current = this.getElementAt(index)
        const previous = current.prev
        previous.next = current.next
        current.next.prev = previous
      }
      this.count--
      return current.element
    }
    return undefined
  }


  // 返回元素在链表中的索引，如果没有该元素返回-1
  indexOf (element) {
    let current = this.head
    let index = 0
    while (current != null) {
      if (this.equalsFn(element, current.element)) {
        return index
      }
      index++
      current = current.next
    }
    return -1
  }


  // 返回头节点
  // getHead() {
  //     return this.head
  // }


  // 返回尾节点
  getTail () {
    return this.tail
  }


  // 清空链表
  clear () {
    super.clear()
    this.tail = undefined
  }


  // 从尾到头转为字符串
  inverseToString () {
    if (this.tail == null) {
      return ''
    }
    let objString = `${this.tail.element}`
    let previous = this.tail.prev
    while (previous != null) {
      objString = `${objString},${previous.element}`
      previous = previous.prev
    }
    return objString
  }


}