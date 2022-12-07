// 快速排序
// eslint-disable-next-line @typescript-eslint/no-unused-vars
function quickSort(arr: number[], left?: number, right?: number): number[] {
  let partitionIdx = 0
  const leftIdx = left || 0
  const rightIdx = right || arr.length - 1
  if (leftIdx < rightIdx) {
    partitionIdx = partition(arr, leftIdx, rightIdx)
    quickSort(arr, leftIdx, partitionIdx - 1)
    quickSort(arr, partitionIdx + 1, rightIdx)
  }
  return arr
}

// 选择最左值为基准值，将left->right中的值，小于基准值的放在左边，大于基准值的放在右边
// 放置好后，基准位置向前一步（意味着基准位置前的数据均比基准位置小）
function partition(arr: number[], left: number, right: number): number {
  let placeIdx = left + 1
  for (let i = left + 1; i <= right; i++) {
    if (arr[i] < arr[left]) {
      const temp = arr[i]
      arr[i] = arr[placeIdx]
      arr[placeIdx] = temp
      placeIdx++
    }
  }
  const temp = arr[left]
  arr[left] = arr[placeIdx - 1]
  arr[placeIdx - 1] = temp
  return placeIdx - 1
}
