import { Pair } from './Pair';
// 基于数组实现哈希表

class ArrayHashMap {
  private readonly buckets: (Pair | null)[];

  constructor() {
    // 初始化数组，包含100个桶
    this.buckets = new Array(100).fill(null);
  }

  // 哈希函数
  private hashFunc(key: number): number {
    return key % 100;
  }

  // 查询操作
  public get(key: number): string | null {
    let index = this.hashFunc(key);
    let pair = this.buckets[index];
    if(pair === null) return null;
    return pair.val;
  }

  // 添加操作
  public set(key: number, val: string) {
    let index = this.hashFunc(key);
    this.buckets[index] = new Pair(key, val);
  }

  // 删除操作
  public delete(key: number) {
    let index = this.hashFunc(key);
    this.buckets[index] = null;
  }

  // 获取所有键值对
  public entries(): (Pair | null)[] {
    let arr: (Pair | null)[] = [];
    for(let i=0;i<this.buckets.length;i++) {
      if(this.buckets[i]) {
        arr.push(this.buckets[i]);
      }
    }
    return arr;
  }

  // 获取所有键
  public keys(): (number | undefined)[] {
    let arr: (number | undefined)[] = [];
    for(let i=0;i<this.buckets.length;i++) {
      if(this.buckets[i]) {
        arr.push(this.buckets[i]!.key);
      }
    }
    return arr;
  }

  // 获取所有值
  public values(): (string | undefined)[] {
    let arr: (string | undefined)[] = [];
    for(let i=0;i<this.buckets.length;i++) {
      if(this.buckets[i]) {
        arr.push(this.buckets[i]!.val);
      }
    }
    return arr;
  }

  // 打印哈希表
  public print() {
    let pairSet = this.entries();
    for(const pair of pairSet) {
      console.info(`${pair!.key} -> ${pair!.val}`);
    }
  }
}
