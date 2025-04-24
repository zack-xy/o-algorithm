import { binarySearchInsertion } from './binary_search_insertion';

// 二分查找最左一个target
function binarySearchLeftEdge(nums: Array<number>, target: number): number {
  const i = binarySearchInsertion(nums, target);
  if(i === nums.length || nums[i] !== target) {
    return -1
  }
  return i;
}

// 二份查找最右一个target
function binarySearchRightEdge(nums: Array<number>, target: number): number {
  const i = binarySearchInsertion(nums, target + 1);
  const j = i - 1;
  if(j === -1 || nums[j] !== target) {
    return -1;
  }
  return j;
}
