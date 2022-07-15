class Stack {
  constructor() {
    this.data = []
  }

  push(x) {
    this.data.push(x)
  }

  pop() {
    if (this.empty())
      return
    this.data.pop()
  }

  empty() {
    return this.data.length === 0
  }

  size() {
    return this.data.length
  }

  output() {
    console.log('=======')
    for (let i = this.data.length - 1; i >= 0; i--)
      console.log(this.data[i])

    console.log('=======')
  }
}
