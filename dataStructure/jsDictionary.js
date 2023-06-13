export function defaultToString (item) {
  if (item === null) {
    return 'NULL';
  } else if (item === undefined) {
    return 'UNDEFINED';
  } else if (typeof item === 'string' || item instanceof String) {
    return `${item}`;
  }
  return item.toString();
}

// 为了保存原始的key
export class ValuePair {
  constructor(key, value) {
    this.key = key
    this.value = value
  }
  toString () {
    return `[#${this.key}: ${this.value}]`
  }
}

export default class Dictionary {
  constructor(toStrFn = defaultToString) {
    this.toStrFn = toStrFn
    this.table = {}
  }

  // 添加方法。如果key存在，value会被覆盖
  set (key, value) {
    if (key != null && value != null) {
      const tableKey = this.toStrFn(key)
      this.table[tableKey] = new ValuePair(key, value)
      return true
    }
    return false
  }

  // 移除对应的数据
  remove (key) {
    if (this.hasKey(key)) {
      delete this.table[this.toStrFn(key)]
      return true
    }
    return false
  }

  // 是否存在某个键
  hasKey (key) {
    return this.table[this.toStrFn(key)] != null
  }

  // 以键取值
  get (key) {
    const valuePair = this.table[this.toStrFn(key)]
    return valuePair == null ? undefined : valuePair.value
  }

  // 删除字典所有值
  clear () {
    this.table = {}
  }

  // 返回字典所包值的数量
  size () {
    return Object.keys(this.table).length
  }

  // 字典是否为空
  isEmpty () {
    return this.size() === 0
  }

  // 将字典所包含你的所有键以数组形式返回
  keys () {
    return this.keyValues().map(valuePair => valuePair.key)
  }

  // 将字典所包含的所有值以数组形式返回
  values () {
    return this.keyValues().map(valuePair => valuePair.value)
  }

  // 返回字典所有[键、值]对
  keyValues () {
    return Object.values(this.table)
  }

  // 兼容版本keyValues
  keyValues2 () {
    const valuePairs = []
    for (const k in this.table) {
      if (this.hasKey(k)) {
        valuePairs.push(this.table[k])
      }
    }
    return valuePairs
  }
  // 迭代字典中所有键值对
  forEach (callbackFn) {
    const valuePairs = this.keyValues()
    for (let i = 0; i < valuePairs.length; i++) {
      const result = callbackFn(valuePairs[i].key, valuePairs[i].value)
      if (result === false) {
        break
      }
    }
  }

  toString () {
    if (this.isEmpty()) {
      return ''
    }
    const valuePairs = this.keyValues()
    let objString = `${valuePairs[0].toString()}`
    for (let i = 1; i < valuePairs.length; i++) {
      objString = `${objString},${valuePairs[i].toString()}`
    }
    return objString
  }
}