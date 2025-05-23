package algorithm.排序算法;

import java.util.*;

public class AllSort {

    // 【选择排序】
    // 算法：每次从未排序的数据里选最小的，放在已排序的后面
    // O(n^2)、基于比较、不稳定、原地、非自适应
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        // 外循环：未排序的区间为[i, n - 1]
        for (int i = 0; i < n - 1; i++) {
            // 内循环：找到未排序区间的最小元素
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k]) k = j;  // 记录最小元素的索引
            }
            // 将该最小元素与未排序区间的首个元素交换
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    // 【冒泡排序】
    // 算法：从左到右，依次比较相邻元素大小，如果“左元素>右元素”，就交换二者(最大的会冒泡到最后)
    // O(n^2)、基于比较、稳定、原地、自适应
    public static void bubbleSort(int[] nums) {
        // 外循环：未排序区间为[0,i]
        for(int i = nums.length - 1; i > 0; i--) {
            // 内循环：将未排序区间[0, i]中最大的元素交换到该区间最右端
            for (int j = 0; j < i; j++) {  // （注意这里不是<=i，因为里面是j+1）
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    // 【冒泡排序 - 优化】
    // 如果某轮“冒泡”中没有执行任何交换操作，说明数组已经完成排序，可直接返回结果
    // 增加一个标志位flag监测
    public static void bubbleSortWithFlag (int[] nums) {
        // 外循环：未排序区间为[0,i]
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false; // 初始化标志位
            // 内循环：将未排序区间[0,i]中最大元素交换到该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;  // 此轮没有交换，退出
        }
    }

    // 【插入排序】
    // 算法：在未排序区间选一个基准元素，将该元素与已排序区间的元素逐一比较大小，并将该元素插入到正确的位置
    // O(n^2)、基于比较、稳定、原地、自适应
    // 相比于上面两种，插入排序是用的最多的，而且，如果数据量较小（30个元素以内）的情况下，插入排序比快速排序O(nlogn)还快
    public static void insertionSort(int[] nums) {
        // 外循环：已排序区间为[0, i-1]
        for (int i = 1; i < nums.length; i++) {   // (i最大到len-1)
            int base = nums[i], j = i - 1;        // （j指向i的前1个位置，j最大到len-2）
            // 内循环：将base插入到已排序区间[0, i-1]中的正确位置
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    // 【快速排序】
    // 算法：选择数组中某个元素作为基准数，小于基准数的移到其左侧，大于基准的元素移到其右侧
    // O(nlogn)、基于比较、不稳定、原地、非自适应
    public static void quickSort(int[] nums, int left, int right) {
        // 子数组长度为1时终止递归
        if (left >= right) return;
        // 哨兵划分, partition会返回一个基准位置，基准位置的左侧值均小于基准值，右侧值均大于基准值
        int pivot = partition(nums, left, right);
        // 递归左子数组，右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    // 哨兵划分
    private static int partition(int[] nums, int left, int right) {
        // 以nums[left]为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            // 上面两个while不执行了，一定是j的位置小于基准值并且i的位置大于基准值
            // 因为如果是i>j跳出循环，就会跳出最外层的while
            swap(nums, i ,j);
        }
        // 思考一下，left表示的值是？i表示的值是？
        // 上面的while执行完毕，left处表示的是基准值，基准值后面，一部分是小于基准值的，一部分是大于基准值的，
        // 已经排好序了，除了基准值不在里面
        // 根据上面的代码，跳出循环，一定有i>=j
        // 因为先处理的j，也就是在i<j的情况下，j停止处理，必须有nums[j]<nums[left]所以j的位置一定小于基准值
        // 所以一定有i和j重合，且i在最后一个小于基准值的位置
        // 交换i和left，则满足基准值left左侧都是小于基准值的，右侧都是大于基准值的
        swap(nums, i, left);  // 将基准数交换到2个子数组的分界线
        return i;
    }

    // 元素交换(交换i索引和j索引的元素)
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 【快速排序 - 基准数优化】
    // 选3个数中间那个数
    private static int medianThree(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        if ((l <= m && m <= r) || (r<=m && m <= l)) return mid;
        if ((m<=l && l<=r) || (r <= l && l <= m)) return left;
        return right;
    }

    // 三数取中值的哨兵函数
    private static int partition2(int[] nums, int left, int right) {
        int med = medianThree(nums, left, (left + right) /2, right);
        swap(nums, left, med); // 将中位数交换到数组最左端
        // 以nums[left]为基准数
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    // 【快速排序 - 尾递归优化】Java不支持尾递归优化
    public static void quickSort2(int[] nums, int left, int right) {
        // 子数组长度为1时终止
        while (left < right) {
            // 哨兵划分操作
            int pivot = partition2(nums, left, right);
            // 对2个子数组中较短的那个执行快速排序
            if (pivot - left < right - pivot) {
                quickSort2(nums, left, pivot - 1); // 递归排序左子数组
                left = pivot + 1;  // 剩余未排序区间为[pivot + 1, right]
            } else {
                quickSort2(nums, pivot + 1, right);  // 递归排序右子树数组
                right = pivot - 1; // 剩余未排序空间为[left, pivot-1]
            }
        }
    }

    // 因为Java不支持尾递归优化，所以依然可能导致栈溢出
    // 显式栈（迭代法）
    public void quickSortStack(int[] nums, int left, int right) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            if (left >= right) continue;

            int pivot = partition2(nums, left, right);
            // 先处理较短子数组，减少栈深度
            if (pivot - left < right - pivot) {
                stack.push(left);
                stack.push(pivot - 1);

                stack.push(pivot + 1);
                stack.push(right);
            } else {
                stack.push(pivot + 1);
                stack.push(right);

                stack.push(left);
                stack.push(pivot - 1);
            }
        }
    }

    // 【归并排序】
    // 算法：不断递归将数组从中点分开，当子数组长度为1时，停止划分，将2个较短的有序数组合并为一个较长的有序数组
    // O(nlogn)、基于比较、稳定、非原地、非自适应
    public static void mergeSort(int[] nums, int left, int right) {
        // 终止条件
        if (left >= right) return; // 当子数组长度为1时终止递归
        // 划分阶段
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);  // 递归左子数组
        mergeSort(nums, mid+1, right); // 递归右子数组
        // 合并
        merge(nums, left, mid, right);
    }

    // 归并排序的合并操作
    private static void merge(int[] nums, int left, int mid, int right) {
        // 左子数组区间为[left, mid], 右子数组区间为[mid+1, right]
        // 创建一个临时数组tmp，存放合并后的结果
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        // 将左子数组和右子数组的剩余元素复制到临时数组中
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j<=right) {
            tmp[k++] = nums[j++];
        }
        // 将临时数组中的元素复制回原数组中
        for (k = 0; k < tmp.length; k++) {
            nums[left + k] = tmp[k];
        }
    }

    // 【堆排序】
    // 算法：
    // 1. 输入数组并建立大顶堆。完成后，最大元素位于堆顶
    // 2.将堆顶元素（第一个元素）与堆底元素（最后一个元素）交换。完成交换后，堆的长度减1，已排序元素数量加1
    // 3.从堆顶元素开始，从顶到底执行堆化操作。完整堆化后，堆的性质得到修复
    // 4.循转执行2，3，循环n-1轮后，完成数组排序
    // O(nlogn)、基于比较、不稳定、原地、非自适应
    public static void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换根节点与最右叶节点（交换首元素与尾元素）
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 以根节点为起点，从顶至底进行堆化
            siftDown(nums, i, 0);
        }
    }

    // 堆的长度为n，从节点i开始，从顶至底堆化
    private static void siftDown(int[] nums, int n, int i) {
        while (true) {
            // 判断节点i,l,r中值最大的节点，记为ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;
            if (l < n && nums[l] > nums[ma]) ma = l;
            if (r < n && nums[r] > nums[ma]) ma = r;
            // 若节点i最大或索引l，r越界，则无法继续堆化，跳出
            if (ma == i) break;
            // 交换两节点
            int temp = nums[i];
            nums[i] = nums[ma];
            nums[ma] = temp;
            // 循环向下堆化
            i = ma;
        }
    }

    // 【桶排序】
    // 算法：设置一些具有大小顺序的桶，每个桶对应一个数据范围，把数据分配到桶中，每个桶内部进行排序，最终按照桶的顺序合并数据
    // O(n+k)，不比较、稳定，非原地，非自适应
    public static void bucketSort(float[] nums) {
        // 初始化 k = n/2个桶，预期向每个桶分配2个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        // 1. 将数组元素分配到各个桶中
        for (float num : nums) {
            // 输入数据范围为[0, 1),使用num * k映射索引范围[0, k-1)
            int i = (int) (num * k);
            buckets.get(i).add(num);
        }
        // 2. 对各个桶执行排序
        for (List<Float> buckect : buckets) {
            Collections.sort(buckect);
        }
        // 3. 遍历桶合并结果
        int i = 0;
        for (List<Float> buckect : buckets) {
            for (float num : buckect) {
                nums[i++] = num;
            }
        }
    }

    // 【计数排序】(用于整数数组)
    // 算法：需要一个辅助数组统计数字出现的次数，辅助数组的索引是整数值，对应的数组值是这个数字出现的次数
    // 之后按照索引顺序生成数据
    // O(n+m)，不比较、稳定，非原地，非自适应
    public static void countingSortNaive(int[] nums) {
        // 1. 统计数组最大元素m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字出现次数
        int[] counter = new int[m+1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 遍历counter，将各元素填入原数组nums
        int i = 0;
        for (int num = 0; num < m + 1; num++) {
            for (int j = 0;j<counter[num];j++, i++) {
                nums[i] = num;
            }
        }
    }

    // 完整实现
    public static void countingSort(int[] nums) {
        // 1. 统计数组最大元素m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        // 2. 统计各数字的出现次数
        // counter[num] 代表 num 的出现次数
        int[] counter = new int[m+1];
        for (int num : nums) {
            counter[num]++;
        }
        // 3. 求counter的前缀和，将“出现次数”转换为“尾索引”
        // 即counter[num]-1是num在res中最后一次出现的索引
        for(int i=0;i<m;i++) {
            counter[i+1] += counter[i];
        }
        // 4. 倒序遍历nums，将各元素填入结果数组res
        // 初始化数组res用于记录结果
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n-1;i>=0;i--) {
            int num = nums[i];
            res[counter[num] - 1] = num;
            counter[num]--;
        }
        // 使用结果数组 res 覆盖原数组nums
        for (int i=0;i<n;i++) {
            nums[i] = res[i];
        }
    }

    // 【基数排序】（适用于数据量大但是范围小）
    // 算法：
    // O(nk)，不比较、稳定，非原地，非自适应
    public static void radixSort(int[] nums) {
        // 获取数组的最大元素，用于判断最大位数
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > m) m = num;
        }
        for (int exp = 1;exp <= m; exp *= 10) {
            countingSortDigit(nums, exp);
        }
    }

    private static void countingSortDigit(int[] nums, int exp) {
        // 十进制的位范围为0-9，因此需要长度为10的桶数组
        int[] counter = new int[10];
        int n = nums.length;
        // 统计 0-9 各数字的出现次数
        for (int i = 0; i < n;i++) {
            int d = digit(nums[i], exp);
            counter[d]++;
        }
        for (int i=1;i<10;i++) {
            counter[i] += counter[i-1];
        }
        int[] res = new int[n];
        for (int i = n-1;i>=0;i--) {
            int d = digit(nums[i], exp);
            int j = counter[d] - 1;
            res[j] = nums[i];
            counter[d]--;
        }
        // 使用结果覆盖原数组
        for (int i=0;i<n;i++) nums[i] = res[i];
    }

    private static int digit(int num, int exp) {
        return (num / exp) % 10;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4,9,7,8,6,8};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
