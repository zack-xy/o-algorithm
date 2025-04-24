// 二分查找插入点（无重复元素）
// 返回插入的位置索引
function binarySearchInsertionSimple(
  nums: Array<number>,
  target: number
): number {
  let i=0,
      j=nums.length-1;
  while(i<=j) {
    const m = Math.floor(i + (j - i)/2);
    if(nums[m] < target) {
      i = m + 1;
    } else if(nums[m] > target) {
      j = m - 1;
    } else {
      return m;
    }
  }
  return i;
}

// 二分查找插入点（存在重复元素）
function binarySearchInsertion(nums: Array<number>, target: number): number {
  let i=0,
      j=nums.length-1;
  while(i<=j) {
    const m = Math.floor(i+(j-i)/2);
    if(nums[m]<target) {
      i = m + 1;
    } else if(nums[m] > target) {
      j = m - 1;
    } else {
      j = m -1;
    }
  }
  return i;
}

export { binarySearchInsertion }
