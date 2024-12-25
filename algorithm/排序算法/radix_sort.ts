// 获取元素 num 的第k位，其中 exp = 10^(k-1)
function digit(num: number, exp: number): number {
  return Math.floor(num / exp) % 10;
}


// 计数排序（根据 nums 第 k 位排序）
function countingSortDigit(nums: number[], exp: number): void {
  // 十进制的位范围位 0 ～ 9，因此需要长度位10的桶数组
  const counter = new Array(10).fill(0);
  const n = nums.length;
  // 统计0～9各数字的出现次数
  for(let i=0;i<n;i++) {
    // 获取nums[i]第k位，记为d
    const d = digit(nums[i], exp);
    // 统计数字d的出现次数
    counter[d]++;
  }
  // 求前缀和，将“出现个数”转换为“数组索引”
  for(let i=1;i<10;i++) {
    counter[i]+=counter[i-1];
  }
  // 倒序遍历，根据桶内统计结果，将各元素填入res
  const res = new Array(n).fill(0);
  for(let i=n-1;i>=0;i--) {
    const d = digit(nums[i], exp);
    // 获取d在数组中的索引j
    const j = counter[d]-1;
    // 将当前元素填入索引j
    res[j] = nums[i];
    counter[d]--;  
  }
  // 使用结果覆盖原数组nums
  for(let i=0;i<n;i++) {
    nums[i]=res[i];
  }
}

// 基数排序
function radixSort(nums: number[]): void {
  // 获取数组的最大元素，用于判断最大位数
  let m = Number.MIN_VALUE;
  for(const num of nums) {
    if(num > m) {
      m = num;
    }
  }
  // 按照从低位到高位的顺序遍历
  for(let exp = 1;exp <= m; exp *= 10) {
    // 对数组元素的第k位执行计数排序
    // k = 1 -> exp = 1
    // k = 2 -> exp = 10
    // 即 exp = 10^(k-1)
    countingSortDigit(nums, exp);
  }
}
