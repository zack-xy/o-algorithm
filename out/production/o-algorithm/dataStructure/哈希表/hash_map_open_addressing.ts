import { Pair } from './Pair';
// 开放寻址哈希表
// 一维数组
class HashMapOpenAddressing {
  private size: number;  // 键值队数量
  private capacity: number; // 哈希表容量
  private loadThres: number; // 触发扩容负载因子阈值
  private extendRatio: number; // 扩容倍数
  private buckets: Array<Pair | null>;  // 桶数组
  private TOMBSTONE: Pair;   // 删除标记

  constructor() {
    this.size = 0;
    this.capacity = 4;
    this.loadThres = 2.0 / 3.0;
    this.extendRatio = 2;
    this.buckets = Array(this.capacity).fill(null);
    this.TOMBSTONE = new Pair(-1, '-1');  // 删除标记
  }

  // 哈希函数
  private hashFunc(key: number): number {
    return key % this.capacity;
  }

  // 负载因子
  private loadFactor(): number {
    return this.size / this.capacity;
  }

  // 搜索key对应的桶索引
  private findBucket(key: number): number {
    let index = this.hashFunc(key);
    let firstTombstone = -1;
    while(this.buckets[index] !== null) {
      // 找到了
      if(this.buckets[index]!.key === key) {
        // 看之前是不是遇到了删除标记，遇到了把数据挪到删除标记这里
        if(firstTombstone !== -1) {
          this.buckets[firstTombstone] = this.buckets[index];
          this.buckets[index] = this.TOMBSTONE;
          return firstTombstone;
        }
        return index;
      }
      if(firstTombstone === -1 && this.buckets[index] === this.TOMBSTONE) {
        firstTombstone = index;
      }
      // 索引位+1
      index = (index + 1) % this.capacity;
    }
    // 没找到,返回添加点的索引
    return firstTombstone === -1 ? index :  firstTombstone;
  }

  // 查询操作
  get(key: number): string | null {
    const index = this.findBucket(key);
    if(this.buckets[index] !== null && this.buckets[index] !== this.TOMBSTONE) {
      return this.buckets[index]!.val;
    }
    return null;
  }

  // 添加操作
  put(key: number, val: string): void {
    // 当负载因子超过阈值时，执行扩容
    if(this.loadFactor() > this.loadThres) {
      this.extend();
    }
    const index = this.findBucket(key);
    if(this.buckets[index] !== null && this.buckets[index] !== this.TOMBSTONE) {
      this.buckets[index]!.val = val;
      return;
    }
    this.buckets[index] = new Pair(key, val);
    this.size++;
  }

  // 删除操作
  remove(key: number): void {
    const index = this.findBucket(key);
    if(this.buckets[index] !== null && this.buckets[index] !== this.TOMBSTONE) {
      this.buckets[index] = this.TOMBSTONE;
      this.size--;
    }
  }

  // 扩容哈希表
  private extend(): void {
    const bucketsTmp = this.buckets;
    this.capacity *= this.extendRatio;
    this.buckets = Array(this.capacity).fill(null);
    this.size = 0;
    for(const pair of bucketsTmp) {
      if(pair !== null && pair !== this.TOMBSTONE) {
        this.put(pair.key, pair.val);
      }
    }
  }

  // 打印哈希表
  print(): void {
    for(const pair of this.buckets) {
      if(pair === null) {
        console.log('null');
      } else if(pair === this.TOMBSTONE) {
        console.log('TOMBSTONE');
      } else {
        console.log(pair.key + ' -> ' + pair.val);
      }
    }
  }
}
