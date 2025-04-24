// 在数组的索引index处插入元素num
function insert(nums: number[], num: number, index: number): void {
  // 把索引index及之后的元素向后移动一位
  for(let i = nums.length - 1; i > index; i--) {
    nums[i] = nums[i-1];
  }
  nums[index] = num;
}


// 删除索引index处的元素
function remove(nums: number[], index: number): void {
  // 把索引index之后的所有元素向前移动一位
  for(let i = index; i < nums.length - 1; i++) {
    nums[i] = nums[i + 1];
  }
}

// 扩容数组，这里认为数组长度不可变的数组
function extend(nums: number[], enlarge: number): number[] {
  const res = new Array(nums.length + enlarge).fill(0);
  for(let i = 0;i < nums.length; i++) {
    res[i] = nums[i];
  }
  return res;
}
