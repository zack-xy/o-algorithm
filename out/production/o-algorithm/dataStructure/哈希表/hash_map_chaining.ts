import { Pair } from './Pair';

// 链式地址哈希表
// 这里的链用的不是链表，用的是数组
class HashMapChaining {
  #size: number;  // 键值队数量
  #capacity: number; // 哈希表容量
  #loadThres: number; // 触发扩容的负载因子阈值
  #extendRatio: number;  // 扩容倍数
  #buckets: Pair[][]; // 桶数组

  constructor() {
    this.#size = 0;
    this.#capacity = 4;
    this.#loadThres = 2.0 / 3.0;
    this.#extendRatio = 2;
    this.#buckets = new Array(this.#capacity).fill(null).map(x => []);
  }

  // 哈希函数
  #hashFunc(key: number): number {
    return key % this.#capacity;
  }

  // 负载因子
  #loadFactor(): number {
    return this.#size / this.#capacity;
  }

  // 查询操作
  get(key: number): string | null {
    const index = this.#hashFunc(key);
    const bucket = this.#buckets[index];
    for(const pair of bucket) {
      if(pair.key === key) {
        return pair.val;
      }
    }
    return null;
  }

  // 添加操作
  put(key: number, val: string): void {
    // 当负载因子超过阈值时，进行扩容
    if(this.#loadFactor() > this.#loadThres) {
      this.#extend();
    }
    const index = this.#hashFunc(key);
    const bucket = this.#buckets[index];
    // 如果存在key，直接更新val
    for(const pair of bucket) {
      if(pair.key === key) {
        pair.val = val;
        return;
      }
    }
    // 如果不存在key，将键值队添加到尾部
    const pair = new Pair(key, val);
    bucket.push(pair);
    this.#size++;
  }

  // 删除操作
  remove(key: number): void {
    const index = this.#hashFunc(key);
    let bucket = this.#buckets[index];
    for(let i=0;i<bucket.length;i++) {
      if(bucket[i].key === key) {
        bucket.splice(i, 1);
        this.#size--;
        break;
      }
    }
  }

  // 扩容哈希表
  #extend(): void {
    const bucketsTmp = this.#buckets;
    this.#capacity *= this.#extendRatio;
    this.#buckets = new Array(this.#capacity).fill(null).map(x => []);
    this.#size = 0;
    for(const bucket of bucketsTmp) {
      for(const pair of bucket) {
        this.put(pair.key, pair.val);
      }
    }
  }

  // 打印哈希表
  print(): void {
    for(const bucket of this.#buckets) {
      let res: string[] = [];
      for(const pair of bucket) {
        res.push(pair.key + '->' + pair.val);
      }
      console.log(res);
    }
  }
}
