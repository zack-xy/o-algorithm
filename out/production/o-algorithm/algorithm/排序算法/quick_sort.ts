// 快速排序类
class QuickSort {
  swap(nums: number[], i: number, j: number): void {
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  // 哨兵划分
  partition(nums: number[], left: number, right: number): number {
    // 以nums[left]为基准数
    let i = left,
        j = right;
    while(i<j) {
      while(i<j && nums[j] >= nums[left]) {
        j-=1;
      }
      while(i<j && nums[i] <= nums[left]) {
        i+=1;
      }
      this.swap(nums, i ,j);
    }
    this.swap(nums, i, left);
    return i;
  }

  // 快速排序
  quickSort(nums: number[], left: number, right: number): void {
    if(left >= right) {
      return;
    }
    const pivot = this.partition(nums, left, right);
    this.quickSort(nums, left, pivot-1);
    this.quickSort(nums, pivot+1, right);
  }
}


// 快速排序（中位基准数优化）
class QuickSortMedian {
  swap(nums: number[], i: number, j: number) {
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  // 选取三个候选元素的中位数
  // 参数是索引，返回索引
  medianThree(
    nums: number[],
    left: number,
    mid: number,
    right: number
  ): number {
    let l = nums[left],
        m = nums[mid],
        r = nums[right];
    if((l <= m && m <= r) || (r <= m && m <= l)) return mid;
    if((m <= l && l <= r) || (r <= l && l <= m)) return left;
    return right;
  }

  // 哨兵划分（三数取中值）
  partition(nums: number[], left: number, right: nunber): number {
    let med = this.medianThree(
      nums,
            left,
            Math.floor((left + right) / 2),
            right
    );
    // 将中位数交换至数组最左端
    this.swap(nums, left, med);
    let i = left,
        j = right;
    while(i<j) {
      while(i<j && nums[j] >= nums[left]) {
        j--;
      }
      while(i<j && nums[i] <= nums[left]) {
        i++;
      }
      this.swap(nums, i, j);
    }
    this.swap(nums, i, left);
    return i;
  }

  quickSort(nums: number[], left: number, right: number): void {
    if(left >= right) {
      return;
    }
    // 哨兵划分
    const pivot = this.partition(nums, left, right);
    this.quickSort(nums, left, pivot-1);
    this.quickSort(nums, pivot+1, right);
  }
}

// 快速排序类（尾递归优化）
class QuickSortTailCall {
  // 元素交换
  swap(nums: number[], i: number, j: number): void {
    let tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  // 哨兵划分
  partition(nums: number[], left: number, right: number): number {
    let i = left,
        j = right;
    while(i<j) {
      while(i<j && nums[j] >= nums[left]) {
        j--;
      }
      while(i<j && nums[i] <= nums[left]) {
        i++;
      }
      this.swap(nums, i, j);
    }
    this.swap(nums, i, left);
    return i;
  }

  // 快速排序（尾递归优化）
  quickSort(nums: number[], left: number, right: number): void {
    while(left < right) {
      // 哨兵划分操作
      let pivot = this.partition(nums, left, right);
      // 对两个子数组中较短的那个执行快速排序
      if(pivot - left < right - pivot) {
        this.quickSort(nums, left, pivot - 1);
        left = pivot + 1;
      } else {
        this.quickSort(nums, pivot + 1, right);
        right = pivot - 1;
      }
    }
  }
}
