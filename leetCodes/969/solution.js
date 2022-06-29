const swap = function (array, a, b) {
  const temp = array[a]
  array[a] = array[b]
  array[b] = temp
}

// 翻转前n位并且记录元素位置
const reverse = function (arr, n, ind) {
  for (let i = 0, j = n - 1; i < j; i++, j--) {
    swap(arr, i, j)
    ind[arr[i]] = i
    ind[arr[j]] = j
  }
}

/**
 * @param {number[]} arr
 * @return {number[]}
 */
// 提示写明arr数组是1-arr.length的排列，数互不相同
// eslint-disable-next-line @typescript-eslint/no-unused-vars
const pancakeSort = function (arr) {
  const ind = {} // 记录每个元素的位置
  const ret = []
  for (let i = 0; i < arr.length; i++) ind[arr[i]] = i
  for (let i = arr.length; i >= 1; i--) {
    if (ind[i] === i - 1)
      continue
    if (ind[i] + 1 !== 1) {
      ret.push(ind[i] + 1)
      reverse(arr, ind[i] + 1, ind)
    }
    if (i !== 1) {
      ret.push(i)
      reverse(arr, i, ind)
    }
  }
  return ret
}
