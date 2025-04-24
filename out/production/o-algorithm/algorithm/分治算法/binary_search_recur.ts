// 二分查找
function dfs(nums: number[], target: number, i: number, j: number): number {
  // 若区间为空，代表无目标元素，则返回 -1
  if(i > j) {
    return -1;
  }
  // 计算中点索引 m
  const m = i + ((j - i) >> 1);
  if(nums[m] < target) {
    // 递归子问题 f(m+1, j)
    return dfs(nums, target, m + 1, j);
  } else if(nums[m] > target) {
    // 递归子问题 f(i, m-1)
    return dfs(nums, target, i, m-1);
  } else {
    // 找到目标元素，返回其索引
    return m;
  }
}

// 二分查找
function binarySearch(nums: number[], target: number): number {
  const n = nums.length;
  // 求解问题 f(0, n-1)
  return dfs(nums, target, 0, n - 1);
}
