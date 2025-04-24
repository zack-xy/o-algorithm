class Set {
  constructor() {
    this.items = {}
  }

  // 向集合添加一个新元素
  add (element) {
    if (!this.has(element)) {
      this.items[element] = element
      return true
    }
    return false
  }
  // 从集合移除一个元素
  delete (element) {
    if (this.has(element)) {
      delete this.items[element]
      return true
    }
    return false
  }
  // 元素有返回true，否则false
  has (element) {
    return Object.prototype.hasOwnProperty.call(this.items, element)
  }
  // 移除集合所有元素
  clear () {
    this.items = {}
  }
  // 返回集合大小
  size () {
    return Object.keys(this.items).length
  }
  // 兼容版本size()
  sizeLegacy () {
    let count = 0
    for (let key in this.items) {
      if (this.items.hasOwnProperty(key)) {
        count++
      }
    }
    return count
  }
  // 返回所有值
  values () {
    return Object.values(this.items)
  }
  toString () {
    if (this.isEmpty()) {
      return '';
    }
    const values = this.values();
    let objString = `${values[0]}`;
    for (let i = 1; i < values.length; i++) {
      objString = `${objString},${values[i].toString()}`;
    }
    return objString;
  }
  // 是否为空
  isEmpty () {
    return this.size() === 0;
  }
  // 兼容版本values
  valuesLegacy () {
    let values = []
    for (let key in this.items) {
      if (this.items.hasOwnProperty(key)) {
        values.push(key)
      }
    }
    return values
  }

  // 并集运算
  union (otherSet) {
    const unionSet = new Set()
    this.values().forEach(value => unionSet.add(value))
    otherSet.values().forEach(value => unionSet.add(value))
    return unionSet
  }

  // 交集运算
  intersection (otherSet) {
    const intersectionSet = new Set()

    const values = this.values()
    const otherValues = otherSet.values()
    let biggerSet = values
    let smallerSet = otherValues
    if (otherValues.length - values.length > 0) {
      biggerSet = otherValues
      smallerSet = values
    }
    smallerSet.forEach(value => {
      if (biggerSet.includes(value)) {
        intersectionSet.add(value)
      }
    })
    return intersectionSet
  }

  // 差集运算
  difference (otherSet) {
    const differenceSet = new Set()
    this.values().forEach(value => {
      if (!otherSet.has(value)) {
        differenceSet.add(value)
      }
    })
    return differenceSet
  }

  // 是否是子集
  isSubsetOf (otherSet) {
    if (this.size() > otherSet.size()) {
      return false
    }
    let isSubset = true
    this.values().every(value => {
      if (!otherSet.has(value)) {
        isSubset = false
        return false
      }
      return true
    })
    return isSubset
  }
}