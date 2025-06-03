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

    // 如果是有重复元素，如果查找的元素重复，则找左侧第1个
    // 虽然我不知道找到的索引是在最左边还是中间还是最右边，但是我可以向左探测，走到最左边
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

    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <=  right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        // 【如果target存在】返回的是target重复区间的最左侧索引
        //  【如果target不存在】返回第1个大于target的位置
        // 为什么呢？
        // 因为只要比target小，left就要往前进，最终会停在第一个大于等于target的位置
        // 只要大于等于target，right就要往前进，最终会停在最后一个小于target的位置
        return left;
        // 如果 return right;
        // 【如果target存在】返回的target重复区间左侧的前1个位置
        // 【如果target不存在】最终会停在最后一个小于target的位置
    }

    public int search4(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }



}
