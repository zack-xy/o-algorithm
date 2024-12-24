// 合并左子数组和右子数组
function merge(nums: number[], left: number, mid: number, right: number): void {
  // 左子数组区间为[left, mid],右子数组区间为[mid+1, right]
  // 创建一个临时数组tmp，用于存放合并后的结果
  const tmp = new Array(right - left + 1);
  let i = left,
      j = mid + 1,
      k = 0;
  while(i <= mid && j <= right) {
    if(nums[i] <= nums[j]) {
      tmp[k++] = nums[i++]
    } else {
      tmp[k++] = nums[j++]
    }
  }
  while(i<=mid) {
    tmp[k++] = nums[i++];
  }
  while(j<=right) {
    tmp[k++] = nums[j++];
  }
  // 将临时数组tmp中的元素复制回原数组nums对应的区间
  for(k=0;k<tmp.length;k++) {
    nums[left + k] = tmp[k];
  }
}

// 归并排序
function mergeSort(nums: number[], left: number, right: number):  void {
  // 终止条件，当子数组长度为1时终止递归
  if(left >= right) return;
  // 划分阶段
  let mid = Math.floor(left + (right - left) / 2);
  mergeSort(nums, left, mid);
  mergeSort(nums, mid+1, right);
  merge(nums, left, mid, right);
}
