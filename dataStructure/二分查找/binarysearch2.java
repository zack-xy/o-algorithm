package dataStructure.二分查找;

public class binarysearch2 {

    // 如果存在重复元素的时候，返回的索引【 可能是最左，可能是最右，可能在中间 】
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) right = mid - 1;
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] == target) return mid;
        }
        return -1;
    }

    // 如果是有重复元素，如果查找的元素重复，则找左侧第1个【线性探查】
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0,right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 找到之后，往左找
                while (mid != 0 && nums[mid] == target) mid--;
                if (mid == 0 && nums[mid] == target) return mid;
                return mid + 1;
            }
        }
        return -1;
    }

    // 存在重复元素 - 获得第一个等于target的索引
    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) right = mid - 1;  // 先处理>=，意味着right停止在【小于】target处
            else left = mid + 1;   // 因为前置的处理，left与right相遇处，是最后一个【小于】target处，下一次处理，循环退出，停在【第一个大于等于target的位置】
        }
        int result = right + 1;   // 防止索引越界
        return (result < nums.length && nums[result] == target) ? result : -1;
    }

    // 存在重复元素 - 获得最后一个等于target的索引
    public int search4(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) left = mid + 1; // 先处理<=，意味着left停止在【大于】target处
            else right = mid - 1;  // 因为前置的处理，left与right相遇处，是第一个【大于】target处，下一次处理，循环退出，停在【最后一个“大于”等于target的位置】
        }
        if (right >= 0 && nums[right] == target) return right;
        return -1;
    }


    /**
     *
     * ⚠️注意⚠️ 有关于索引溢出的问题
     *
     *     // 针对函数 search
     *     // 当退出循环的时候，其实left和right其中有一个索引已经溢出了
     *     // 只不过因为返回的数据不使用left和right，而且一旦索引溢出，循环就退出了，所以没有影响
     *
     *     // search3防止越界的处理也可以这么写
     *     if (left < nums.length && nums[left] == target) return left;
     *     return -1;
     *
     *     所以因为left和right是函数的返回，所以判断一处越界就好了。无论判断哪一个都是可以的
     *
     *
     */



}
