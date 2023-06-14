class MyArray<E> {
    private data: E[] = []
    private size: number = 0
    constructor(capacity?: number) {
        this.data = new Array<E>(capacity ? capacity : 10)
    }
    public getSize(): number {
        return this.size
    }

    public getCapacity(): number {
        return this.data.length
    }
    public isEmpty(): boolean {
        return this.size === 0
    }

    public addLast(e: E): void {
        this.add(this.size, e)
    }

    public addFirst(e:E): void {
        this.add(0, e)
    }

    // 插入数据
    public add(index: number, e: E): void {
        if(index < 0 || index > this.size) throw new Error('index is invalid')
        if(this.size === this.data.length) {
            // TODO 动态数组
            this.resize(2 * this.data.length)
        }
        for (let i = this.size - 1; i >= index; i--) this.data[i + 1] = this.data[i]
        this.data[index] = e
        this.size++
    }

    public get(idx: number): E {
        if(idx < 0 || idx >= this.size) throw new Error('get failed')
        return this.data[idx]
    }

    public set(idx: number, e: E) {
        if(idx < 0 || idx >= this.size) throw new Error('set failed')
        this.data[idx] = e
    }

    public contains(e: E):boolean {
        for (let i = 0; i < this.size; i++) {
            if(this.data[i] == e) return true;
        }
        return false;
    }

    public remove(idx: number): E {
        if(idx < 0 || idx >= this.size) throw new Error('remove failed')
        let ret = this.data[idx];
        for (let i = idx + 1; i < this.size; i++) this.data[i - 1] = this.data[i];
        this.size--;
        if(this.size === this.data.length / 2) this.resize(this.data.length / 2); // 缩小数组
        return ret
    }

    public removeFirst(): E {
        return this.remove(0 )
    }

    public removeLast(): E {
        return this.remove(this.size - 1)
    }

    public find(e: E): number {
        for (let i = 0; i < this.size; i++) {
            if(this.data[i] == e) return i
        }
        return -1;
    }

    public removeElement(e: E): void {
        let idx = this.find(e);
        if(idx !== -1) this.remove(idx);
    }

    public toString(): string {
        let str: string = `Array: size = ${this.size}, capacity = ${this.data.length}\n`
        str+='['
        for (let i = 0; i < this.size; i++) {
            str+=this.data[i];
            if(i != this.size - 1) str+=',';
        }
        str+=']'
        return str
    }

    // 扩大数组大小
    private resize(newCapacity: number): void {
        let newData: E[] = new Array<E>(newCapacity);
        for (let i = 0; i < this.size; i++) {
            newData[i] = this.data[i]
        }
        this.data = newData
    }

}


// 测试使用代码
let myArr = new MyArray<number>(20)
for (let index = 0; index < 10; index++) {
    myArr.addLast(index)
}
myArr.add(1, 100)
console.log(myArr.toString());
