function twoSum(nums: number[], target: number): number[] {
  let helperMap: Map<number, number> = new Map();
  let index: number | undefined;
  let resArr: number[] = [];
  for (let i = 0, length = nums.length; i < length; i++) {
      index = helperMap.get(target - nums[i]);
      if (index !== undefined) {
          resArr = [i, index];
      }
      helperMap.set(nums[i], i);
  }
  return resArr;
};
