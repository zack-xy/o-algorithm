import { MaxHeap } from './my_heap';

// 元素入堆
function pushMinHeap(maxHeap: MaxHeap, val: number): void {
  maxHeap.push(-val);
}

// 元素出堆
function popMinHeap(maxHeap: MaxHeap): number {
  return -maxHeap.pop();
}

// 访问堆顶元素
function peekMinHeap(maxHeap: MaxHeap): number {
  return -maxHeap.peek();
}

// 取出堆中元素
function getMinHeap(maxHeap: MaxHeap): number[] {
  return maxHeap.getMaxHeap().map((num: number) => -num);
}

// 基于堆查找数组中最大的k个元素
function topKHeap(nums: number[], k: number): number[] {
  const maxHeap = new MaxHeap([]);
  // 将数组的前k个元素入堆
  for(let i=0;i<k;i++) {
    pushMinHeap(maxHeap, nums[i]);
  }
  // 从第k+1个元素开始，保持堆的长度为k
  for(let i=k;i<nums.length;i++) {
    // 如果当前元素大于堆顶元素，则将堆顶元素出堆，当前元素入堆
    if(nums[i] > peekMinHeap(maxHeap)) {
      popMinHeap(maxHeap);
      pushMinHeap(maxHeap, nums[i]);
    }
  }
  return getMinHeap(maxHeap);
}

export { topKHeap }
