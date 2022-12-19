/**
 Do not return anything, modify nums in-place instead.
 */

function three_partition(nums: number[], l: number, r: number, mid: number) {
  const swap = (x: number, y: number) => {
    const temp = nums[x]
    nums[x] = nums[y]
    nums[y] = temp
  }
  if (l >= r)
    return l
  let x = -1
  let y = r + 1
  let i = l
  while (i < y) {
    if (nums[i] === mid) {
      i++
    }
    else if (nums[i] < mid) {
      x++
      swap(x, i)
      i++
    }
    else if (nums[i] > mid) {
      y--
      swap(y, i)
    }
  }
}

// eslint-disable-next-line @typescript-eslint/no-unused-vars
function sortColors(nums: number[]): void {
  three_partition(nums, 0, nums.length - 1, 1)
}
