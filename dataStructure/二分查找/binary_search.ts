// 二分查找(双闭区间)
function binarySearch(nums: number[], target: number): number {
  // 初始化双闭区间[0, n-1]
  // 即i，j分别指向数组首元素，尾元素
  let i = 0,
      j = nums.length - 1;
  while(i <= j) {
    // 计算中点索引 m
    const m = Math.floor(i + (j - i) / 2);
    if(nums[m] < target) {
      i = m + 1;
    } else if(nums[m] > target) {
      j = m - 1;
    } else {
      return m;
    }
  }
  return -1;
}

// 二分查找（左闭右开区间）
function binarySearchLCRO(nums: number[], target: number): number {
  // 初始化左闭右开区间[0, n),即i，j分别指向数组首元素、尾元素+1
  let i = 0,
      j = nums.length;
  while(i < j) {
    const m = Math.floor(i + (j - i) / 2);
    if(nums[m] < target) {
      i = m + 1;
    } else if(nums[m] > target) {
      j = m;
    } else  {
      return m;
    }
  }
  return -1;
}

export { binarySearch, binarySearchLCRO }