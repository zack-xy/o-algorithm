class MyList {
  private arr: Array<number>; // 数组（存储列表元素）
  private _capacity: number = 10; // 列表容量
  private _size: number = 0; // 列表长度（当前元素数量）
  private extendRatio: number = 2; // 每次列表扩容的倍数

  constructor() {
    this.arr = new Array(this._capacity);
  }

  // 获取列表长度（当前元素数量）
  public size(): number {
    return this._size;
  }

  // 获取列表容量
  public capacity(): number {
    return this._capacity;
  }

  // 访问元素
  public get(index: number): number {
    if(index < 0 || index >= this._size) throw new Error('索引越界');
    return this.arr[index];
  }

  // 更新元素
  public set(index: number, num: number): void {
    if(index < 0 || index >= this._size) throw new Error('索引越界');
    this.arr[index] = num;
  }

  // 在尾部添加元素
  public add(num: number): void {
    if(this._size === this._capacity) this.extendCapacity();
    this.arr[this._size] = num;
    this._size++;
  }

  // 在中间插入元素
  public insert(index: number, num: number): void {
    if(index < 0 || index >= this._size) throw new Error('索引越界');
    if(this._size === this._capacity) {
      this.extendCapacity();
    }
    for(let j = this._size - 1; j >= index;j--) {
      this.arr[j + 1] = this.arr[j];
    }
    this.arr[index] = num;
    this._size++;
  }

  // 删除元素
  public remove(index: number): number {
    if(index < 0 || index >= this._size) throw new Error('索引越界');
    let num = this.arr[index];
    for(let j = index;j < this._size - 1;j++) {
      this.arr[j] = this.arr[j+1];
    }
    this._size--;
    return num;
  }

  // 列表扩容
  public extendCapacity(): void {
    this.arr = this.arr.concat(new Array(this.capacity() * (this.extendRatio - 1)));
    this._capacity = this.arr.length;
  }

  // 将列表转换为数组
  public toArray(): number[] {
    let size = this.size();
    const arr = new Array(size);
    for(let i=0;i<size;i++) {
      arr[i] = this.get(i);
    }
    return arr;
  }
}

export default MyList
