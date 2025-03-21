package dataStructure.堆;

import java.util.ArrayList;

// 这是一个大顶堆
public class Heap {
    // 堆化的方法
    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        // 找到根、左节点、右节点中最大值的索引
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if(l < size && hT.get(l) > hT.get(largest)) largest = l;
        if(r < size && hT.get(r) > hT.get(largest)) largest = r;

        // 如果根节点不是最大的，交换之并持续堆化
        if(largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    // 往堆中插入一个元素
    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if(size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for(int i = size / 2 - 1;i>=0; i--) {
                heapify(hT, i);
            }
        }
    }

    // 从堆中删除一个元素
    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for(i=0;i<size;i++) {
            if(num == hT.get(i)) break;
        }

        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);

        hT.remove(size - 1);
        for(int j = size / 2 - 1;j>=0;j--) {
            heapify(hT, j);
        }
    }

    // 打印堆
    void printArray(ArrayList<Integer> array, int size) {
        for(Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 测试代码
    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();

        Heap h = new Heap();
        h.insert(array, 3);
        h.insert(array, 4);
        h.insert(array, 9);
        h.insert(array, 5);
        h.insert(array, 2);

        int size = array.size();

        System.out.println("Max-Heap array: ");
        h.printArray(array, size);

        h.deleteNode(array, 4);
        System.out.println("After deleting an element: ");
        h.printArray(array, size);


    }
}
