// 冒泡排序
function bubbleSort(nums: number[]): void {
  for(let i=nums.length-1;i>0;i--) {
    for(let j=0;j<i;j++) {
      if(nums[j] > nums[j+1]) {
        let tmp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = tmp;
      }
    }
  }
}


// 冒泡排序（标志优化）
function bubbleSortWithFlag(nums: number[]): void {
  for(let i=nums.length-1;i>0;i--) {
    let flag = false;
    for(let j=0;j<i;j++) {
      if(nums[j] > nums[j+1]) {
        let tmp = nums[j];
        nums[j] = nums[j+1];
        nums[j+1] = tmp;
        flag = true;
      }
    }
    if(!flag) break;  // 此轮“冒泡”未交换任何元素，直接跳出
  }
}
