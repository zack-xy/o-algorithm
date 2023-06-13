class Node {
  constructor(value) {
    this.value = value
    this.next = null
  }
}

class LinkNodeList {
  constructor() {
    this.head = null
    this.length = 0
  }

  // 新增节点
  append(value) {
    let node  = new Node(value)
    let p = this.head
    if(this.head) {
      // 找到链表最后一个节点，最后节点的next链接到node
      while(p.next) {
        p = p.next
      }
      p.next = node
    } else {
      // 如果没有头节点，就把新创建的节点赋值给头节点
      this.head = node
    }
    this.length++
  }

  print() {
    let p = this.head
    let ret = ''
    if(this.head) {
      do {
        ret+=(p.value+'=>')
        p = p.next
      } while(p.next)
      ret+=p.value
      console.log(ret);
    } else {
      console.log("空链表");
    }
  }
}

let linkList = new LinkNodeList()

linkList.append(1)
linkList.append(2)
linkList.append(3)
linkList.append(4)


console.log(linkList.length);
linkList.print()
