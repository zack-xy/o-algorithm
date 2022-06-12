//声明链表节点
class Node {
  constructor(value) {
    this.val = value
    this.next = null
  }
}


// 声明链表的数据结构
class NodeList {
  constructor(arr) {
    let head = new Node(arr.shift())
    let next = head
    arr.forEach(item => {
      next.next = new Node(item)
      next = next.next
    })
  }
}