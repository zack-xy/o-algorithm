/* eslint-disable unicorn/error-message */
/* eslint-disable @typescript-eslint/no-unused-vars */

// 高效列表

// 链表实现
class NumberListNode {
  value: number
  next: NumberListNode | undefined

  constructor(value: number) {
    this.value = value
    this.next = undefined
  }
}

class NumberLinkedList {
  // 链表一开始为空，头节点和尾节点都指向一个虚拟节点
  private tail: NumberListNode = { value: 0, next: undefined }
  private head: NumberListNode = this.tail

  at(index: number): number {
    let result: NumberListNode | undefined = this.head.next
    while (index > 0 && result !== undefined) {
      result = result.next
      index--
    }

    if (result === undefined)
      throw new RangeError()
    return result.value
  }

  append(value: number) {
    this.tail.next = { value, next: undefined }
    this.tail = this.tail.next
  }
}

// 数组实现
class NumberArrayList {
  private numbers: number[] = []
  private length = 0

  at(index: number): number {
    if (index >= this.length)
      throw new RangeError()
    return this.numbers[index]
  }

  // 这里的实现是一个新数组复制
  // 大部分库将列表实现为具有额外容量的数组，数组的大小比一开始需求更大
  // 所以追加新元素时，不需要创建一个新数组并复制数据
  // 当填满数组时，会分配一个新数组并复制元素
  // 新数组的容量时之前的2倍
  append(value: number) {
    const newNumbers: number[] = new Array(this.length + 1)
    for (let i = 0; i < this.length; i++)
      newNumbers[i] = this.numbers[i]

    newNumbers[this.length] = value
    this.numbers = newNumbers
    this.length++
  }
}

// 具有额外容量的、基于数组的列表实现
class NumberList {
  private numbers: number[] = new Array(1) // 尽量列表是空，一开始容量为1
  private length = 0
  private capacity = 1 // 容量为1

  at(index: number): number {
    if (index >= this.length)
      throw new RangeError()
    return this.numbers[index]
  }

  append(value: number) {
    if (this.length < this.capacity) {
      this.numbers[this.length] = value
      this.length++
      return
    }

    this.capacity = this.capacity * 2
    const newNumbers: number[] = new Array(this.capacity)
    for (let i = 0; i < this.length; i++)
      newNumbers[i] = this.numbers[i]

    newNumbers[this.length] = value
    this.numbers = newNumbers
    this.length++
  }
}

