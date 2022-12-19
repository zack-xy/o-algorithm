// eslint-disable-next-line @typescript-eslint/no-unused-vars
function exchange(nums: number[]): number[] {
  const swap = (x, y) => {
    const temp = nums[x]
    nums[x] = nums[y]
    nums[y] = temp
  }
  if (nums.length === 0)
    return []
  let x = 0
  let y = nums.length - 1
  do {
    while (x < nums.length && nums[x] % 2) x++
    while (y >= 0 && nums[y] % 2 === 0) y--
    if (x <= y) {
      swap(x, y)
      x++
      y--
    }
  } while (x <= y)
  return nums
}
