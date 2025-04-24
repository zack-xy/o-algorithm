// 插入排序
function insertionSort(nums: number[]): void {
  for(let i=1;i<nums.length;i++) {
    const base = nums[i];
    let j=i-1;
    // 内循环，将base插入到已排序区间[0, i-1]中的正确位置
    while(j >= 0 && nums[j] > base) {
      nums[j+1] = nums[j];
      j--;
    }
    nums[j+1] = base;
  }
}
