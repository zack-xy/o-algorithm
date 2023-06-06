/*
 * @lc app=leetcode.cn id=1 lang=typescript
 *
 * [1] 两数之和
 */

// @lc code=start
function twoSum(nums: number[], target: number): number[] {
  let result: number[] = []
  for(let i =0;i<nums.length;i++) {
    for(let j=0;j<nums.length;j++) {
      if(i !== j && nums[i] + nums[j] === target) {
        result[0] = i
        result[1] = j
        break
      }
      continue
    }
    if(result.length > 0) break
  }
  return result
};
// @lc code=end

