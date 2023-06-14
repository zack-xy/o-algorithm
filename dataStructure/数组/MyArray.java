// TODO 实现数组类
public class MyArray<E> {
    private E[] data;
    private int size;

    /**
     *
     * @param capacity 容量
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0
    }

    // 无参数构造函数，不传的话，默认是10
    public Array() {
        this(10)
    }

    // 获取数组元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size === 0
    }

    // 向数组最后添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 插入数据
    public void add(int index, E e) {
        if(index < 0 || index > size) throw new IllegalArgumentException('index is invalid');
        if(size == data.length) {
            // TODO 动态数组
            resize(2 * data.length)
        }
        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = e;
        size++;
    }

    public E get(int idx) {
        if(idx < 0 || idx >= size) throw new IllegalArgumentException('get failed');
        return data[idx];
    }

    public void set(int idx, E e) {
        if(idx < 0 || idx >= size) throw new IllegalArgumentException('set failed');
        data[idx] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) return i;
        }
        return -1;
    }

    public E remove(int idx) {
        if(idx < 0 || idx >= size) throw new IllegalArgumentException('remove failed');
        int ret = data[idx];
        for (int i = idx + 1; i < size; i++) data[i - 1] = data[i];
        size--;
        data[size] = null;
        if(size == data.length / 2) resize(data.length / 2); // 缩小数组
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int idx = find(e);
        if(idx != -1) remove(idx);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i !=  size - 1) res.append(',');
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i]
        }
        data = newData
    }

}