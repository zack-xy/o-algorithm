// 大顶堆的实现

class Heap {
  private heap: Array<number> = []
  private cnt: number = 0
  constructor(size) {
      this.heap = new Array(size)
  }

  // 向上调整
  shift_up(ind) {
      const fatherInd = (ind) => {
          return Math.floor((ind - 1) / 2)
      }
      while (ind && this.heap[fatherInd(ind)] < this.heap[ind]) {
          const temp = this.heap[fatherInd(ind)]
          this.heap[fatherInd(ind)] = this.heap[ind]
          this.heap[ind] = temp
          ind = fatherInd(ind)
      }
  }

  // 向下调整
  shift_down(ind) {
      const n = this.cnt - 1
      while (ind * 2 + 1 <= n) {
          let temp = ind // 三元组中最大值下标
          if (this.heap[temp] < this.heap[ind * 2 + 1]) temp = ind * 2 + 1
          if (ind * 2 + 2 <= n && this.heap[temp] < this.heap[ind * 2 + 2]) temp = ind * 2 + 2
          if (temp === ind) break
          let t = this.heap[temp]
          this.heap[temp] = this.heap[ind]
          this.heap[ind] = t
          ind = temp
      }
  }

  // 向堆中插入元素
  push(x: number) {
      this.heap[this.cnt++] = x
      let ind = this.cnt - 1
      this.shift_up(ind)
  }
  // 弹堆
  pop() {
      if (this.size() === 0) return
      this.heap[0] = this.heap[this.cnt - 1]
      this.heap[this.cnt - 1] = -1 // -1 is empty ?
      this.cnt -= 1
      let ind = 0
      this.shift_down(ind)
  }
  // 查看堆顶元素
  top() {
      return this.heap[0]
  }
  // 返回堆的数量
  size() {
      return this.cnt
  }
  print() {
      let str = ''
      for (let i = 0; i < this.cnt; i++) {
          if (i === this.cnt - 1) str += this.heap[i]
          else str += `${this.heap[i]},`
      }
      return str
  }
}
