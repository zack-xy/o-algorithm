import { defaultToString, ValuePair } from "./jsDictionary";

export default class HashMap {
  constructor(toStrFn = defaultToString) {
    this.toStrFn = toStrFn;
    this.table = {};
  }

  // 更优的散列函数
  djb2HashCode (key) {
    const tableKey = this.toStrFn(key)
    let hash = 5381
    for (let i = 0; i < tableKey.length; i++) {
      hash = (hash * 33) + tableKey.charCodeAt(i)
    }
    return hash % 1013
  }

  // 散列函数
  loseloseHashCode (key) {
    if (typeof key === "number") {
      return key;
    }
    const tableKey = this.toStrFn(key);
    let hash = 0;
    for (let i = 0; i < tableKey.length; i++) {
      hash += tableKey.charCodeAt(i);
    }
    return hash % 37;
  }

  hashCode (key) {
    return this.loseloseHashCode(key);
  }

  // 向散列表添加新项
  put (key, value) {
    if (key != null && value != null) {
      const position = this.hashCode(key);
      this.table[position] = new ValuePair(key, value);
      return true;
    }
    return false;
  }

  // 根据键值从散列表移除值
  remove (key) {
    const hash = this.hashCode(key);
    const valuePair = this.table[hash];
    if (valuePair != null) {
      delete this.table[hash];
      return true;
    }
    return false;
  }

  // 根据键值检索特定的值
  get (key) {
    const valuePair = this.table[this.hashCode(key)];
    return valuePair == null ? undefined : valuePair.value;
  }

  getTable () {
    return this.table;
  }

  isEmpty () {
    return this.size() === 0;
  }

  size () {
    return Object.keys(this.table).length;
  }

  clear () {
    this.table = {};
  }

  toString () {
    if (this.isEmpty()) {
      return "";
    }
    const keys = Object.keys(this.table);
    let objString = `{${keys[0]} => ${this.table[keys[0]].toString()}}`;
    for (let i = 1; i < keys.length; i++) {
      objString = `${objString},{${keys[i]} => ${this.table[
        keys[i]
      ].toString()}}`;
    }
    return objString;
  }
}
