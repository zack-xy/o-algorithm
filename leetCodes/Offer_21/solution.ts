// eslint-disable-next-line @typescript-eslint/no-unused-vars
function exchange(nums: number[]): number[] {
  const leftArr = []
  const rightArr = []
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] % 2 === 0)
      rightArr.push(nums[i])
    else
      leftArr.push(nums[i])
  }
  return [...leftArr, ...rightArr]
}
