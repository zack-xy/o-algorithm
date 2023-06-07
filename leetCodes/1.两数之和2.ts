/*
 * @lc app=leetcode.cn id=1 lang=typescript
 *
 * [1] 两数之和
 */

// @lc code=start
function twoSum(nums: number[], target: number): number[] {
  let obj:{[propName: number]: number} = {}
  for(let i=0;i<nums.length;i++) { 
    let num = nums[i]
    let subNum = target - num
    if(num in obj) {
      return [i, obj[num]]
    } else {
      obj[subNum] = i
    }
  }

};
// @lc code=end

