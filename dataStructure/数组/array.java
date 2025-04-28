package dataStructure.数组;

import java.util.Arrays;

public class array {

    // 数组元素查找
    /**
     *
     * @param arr 待查找数组
     * @param size 已经存放的元素个数
     * @param key 待查找元素
     * @return 查找的元素索引
     */
    public static int findByElement(int[] arr, int size, int key) {
        for (int i=0;i<size;i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }


    // 数组元素插入
    /**
     *
     * @param arr 待处理数组
     * @param size 数组已存储元素个数
     * @param element 要插入数组的元素
     * @return 返回要插入的索引
     */
    public static int addByElementSequence(int[] arr, int size, int element) {
        if (size >= arr.length) return -1;
        int index = size;
        for (int i=0;i<size;i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }
        }
        for (int j = size;j>index;j--) {
            arr[j]=arr[j-1];
        }
        arr[index]=element;
        return index;
    }

    // 数组元素插入，从后到前，一边查找，一遍移动

    /**
     *
     * @param arr 待处理数组
     * @param size 已存数元素个数
     * @param element 要插入的元素
     * @return 返回插入的索引
     */
    public static int addByElementSequence2(int[] arr, int size, int element) {
        if (size >= arr.length) return -1;
        // 如果运行到这一行，说明数组没满，size<arr.length
        int index = 0;
        for (int j=size-1;j>=0;j--) {
            if (arr[j] >= element) {
                arr[j+1]=arr[j];
            } else {
                index = j+1;
                break;
            }
        }
        arr[index]=element;
        return index;
    }

    // 数组元素删除

    /**
     *
     * @param arr 待处理数组
     * @param size 数组已存储元素个数
     * @param key 要删除的元素
     * @return 返回删除完元素数组的大小
     */
    public int removeByElement(int[] arr, int size, int key) {
        int index = -1;
        for (int i=0;i<size;i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i=index+1;i<size;i++)
                arr[i-1]=arr[i];
            size--;
        }
        return size;
    }

    public static void main(String[] args) {

        // 初始化一个数组
        int[] arr = new int[]{1,2,3,4,5,6,7};
        // 初始化一个数组
        int[] nums = {7,6,5,4,3,2,1};

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(nums));

        int[] arr1 = new int[]{1,3,5,7,9,11,13,0,0};
        int[] arr2 = new int[]{7,9,11,13,15,0,0};
        int[] arr3 = new int[]{1,2,3,4,5,0};
        int[] arr4 = new int[]{1,2,3,4,5};

        int idx1 = addByElementSequence2(arr1, 7, 6);
        System.out.println(Arrays.toString(arr1) + "idx is:  " + idx1);
        int idx2 = addByElementSequence2(arr2, 5, 6);
        System.out.println(Arrays.toString(arr2) + "idx is:  " + idx2);
        int idx3 = addByElementSequence2(arr3, 5, 6);
        System.out.println(Arrays.toString(arr3) + "idx is:  " + idx3);
        int idx4 = addByElementSequence2(arr4, 5, 6);
        System.out.println(Arrays.toString(arr4) + "idx is:  " + idx4);

    }
}
