import { defaultCompare, Compare } from "./jsBinarySearchTree";

export function swap (array, a, b) {
  const temp = array[a]
  array[a] = array[b]
  array[b] = temp
}

export function heapify (array) {
  if (array) {
    this.head = array
  }
  const maxIndex = Math.floor(this.size() / 2) - 1
  for (let i = maxIndex; i >= 0; i--) {
    this.siftDown(i)
  }
  return this.heap
}

// ES6的 swap
const swap2 = (array, a, b) => [array[a], array[b]] = [array[b], array[a]]

export class MinHeap {
  constructor(compareFn = defaultCompare) {
    this.compareFn = compareFn
    // 使用数组表示二叉树
    // 给定位置index的节点
    // 左侧子节点的位置是：2 * index + 1
    // 右侧子节点的位置是：2 * index + 2
    // 父节点位置： (index - 1) / 2
    this.heap = []
  }

  getLeftIndex (index) {
    return 2 * index + 1
  }
  getRightIndex (index) {
    return 2 * index + 2
  }
  getParentIndex (index) {
    if (index == 0) {
      return undefined
    }
    return Math.floor((index - 1) / 2)
  }

  // 向堆中插入一个新值，插入成功true，插入失败false
  // 插入堆底，向上移动直至父节点小于这个插入的值
  insert (value) {
    if (value != null) {
      this.heap.push(value)
      this.siftUp(this.heap.length - 1)
      return true
    }
    return false
  }

  // 上移操作
  siftUp (index) {
    let parent = this.getLeftIndex(index)
    while (index > 0 && this.compareFn(this.heap[parent], this.heap[index] === Compare.BIGGER_THAN)) {
      swap(this.heap, parent, index)
      index = parent
      parent = this.getParentIndex(index)
    }
  }

  // 下移操作
  siftDown (index) {
    let element = index
    const left = this.getLeftIndex(index)
    const right = this.getRightIndex(index)
    const size = this.size()
    if (left < size && this.compareFn(this.heap[element], this.heap[left]) === Compare.BIGGER_THAN) {
      element = left
    }
    if (right < size && this.compareFn(this.heap(element), this.heap[right]) === Compare.BIGGER_THAN) {
      element = right
    }
    if (index !== element) {
      swap(this.heap, index, element)
      this.siftDown(element)
    }
  }

  size () {
    return this.heap.length
  }

  isEmpty () {
    return this.size() === 0
  }

  getAsArray () {
    return this.heap
  }

  heapify (array) {
    if (array) {
      this.head = array
    }
    const maxIndex = Math.floor(this.size() / 2) - 1
    for (let i = maxIndex; i >= 0; i--) {
      this.siftDown(i)
    }
    return this.heap
  }

  // 移除最小值（最小堆）或最大值（最大堆）
  extract () {
    if (this.isEmpty()) {
      return undefined
    }
    if (this.size() === 1) {
      return this.heap.shift()
    }
    const removedValue = this.heap.shift()
    this.siftDown(0)
    return removedValue
  }
  // 返回最小值或最大值
  findMinimum () {
    // 最小堆中，最小值总是位于数组的第一个位置
    return this.isEmpty() ? undefined : this.heap[0]
  }
}
