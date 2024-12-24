// 选择排序
function selectionSort(nums: number[]): void {
  let n = nums.length;
  for(let i=0;i<n-1;i++) {
    let k = i;
    for(let j = i+1;j<n;j++) {
      if(nums[j] < nums[k]) {
        k = j;
      }
    }
    // 将最小元素与未排序区间的首个元素交换
    [nums[i], nums[k]] = [nums[k], nums[i]];
  }
}
