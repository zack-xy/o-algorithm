// 队的长度为n，从节点i开始，从顶至底堆化
function siftDown(nums: number[], n: number, i: number): void {
  while(true) {
    // 判断节点i，l，r中值最大的节点，记为ma
    let l = 2 * i + 1;
    let r = 2 * i + 2;
    let ma = i;
    if(l < n && nums[l] > nums[ma]) {
      ma = l;
    }
    if(r < n && nums[r] > nums[ma]) {
      ma = r;
    }
    // 若节点i最大或者l，r越界，则无需继续堆化，跳出
    if(ma === i) {
      break;
    }
    // 交换2个节点
    [nums[i], nums[ma]] = [nums[ma], nums[i]];
    // 循环向下堆化
    i = ma;
  }
}

// 堆排序
function heapSort(nums: number[]): void {
  // 建堆操作：堆化除叶节点之外的所有其他节点
  for(let i = Math.floor(nums.length / 2) -1;i>=0;i--) {
    siftDown(nums, nums.length, i);
  }
  // 从堆中提取最大元素，循环n-1轮
  for(let i = nums.length-1;i>0;i--) {
    // 交换根节点与最右叶节点（交换首元素与尾元素）
    [nums[0], nums[i]] = [nums[i], nums[0]];
    // 以根节点尾起点，从顶至底进行堆化
    siftDown(nums, i, 0);
  }
}
