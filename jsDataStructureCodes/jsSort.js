/* eslint-disable no-redeclare */
// 排序算法

/**
 * 冒泡排序
 * @param {number []} arr
 * @returns {number []}
 */
var bubblingSort = function (arr) {
  for (let len = arr.length, i = len - 1; i > 0; i--) {
    for (let j = 0; j < i; j++) {
      if (arr[j] > arr[j + 1]) {
        const tmp = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = tmp
      }
    }
  }
  return arr
}

/**
 * 选择排序
 * @param {number []} arr
 * @returns {number []}
 */
var selectSort = function (arr) {
  for (let len = arr.length, i = 0; i < len - 1; i++) {
    let min = arr[i]
    for (let j = i + 1; j < len; j++) {
      if (arr[j] < min) {
        min = arr[j]
        arr[j] = arr[i]
        arr[i] = min
      }
    }
  }
  return arr
}

/**
 * 选择排序-范例
 * @param {number []} arr
 * @returns {number []}
 */
var selectionSortExample = function (arr) {
  var len = arr.length
  var minIndex, temp
  for (var i = 0; i < len - 1; i++) {
    minIndex = i
    for (var j = i + 1; j < len; j++) {
      if (arr[j] < arr[minIndex]) {    // 寻找最小的数
        minIndex = j                // 将最小数的索引保存
      }
    }
    temp = arr[i]
    arr[i] = arr[minIndex]
    arr[minIndex] = temp
  }
  return arr
}

/**
 * 快速排序
 * @param {number []} arr
 * @param {number} left
 * @param {number} right
 * @returns {number []}
 */
var quickSort = function (arr, left, right) {
  var partitionIdx
  var left = typeof left === 'number' ? left : 0
  var right = typeof right === 'number' ? right : arr.length - 1
  if (left < right) {
    partitionIdx = partition(arr, left, right)
    quickSort(arr, left, partitionIdx - 1)
    quickSort(arr, partitionIdx + 1, right)
  }
  return arr
}

function partition (arr, left, right) {
  let placeIdx = left + 1
  for (let i = left + 1; i <= right; i++) {
    if (arr[i] < arr[left]) {
      const tmp = arr[i]; arr[i] = arr[placeIdx]; arr[placeIdx] = tmp
      placeIdx++
    }
  }
  const tmp = arr[left]; arr[left] = arr[placeIdx - 1]; arr[placeIdx - 1] = tmp
  return placeIdx - 1
}

/**
 * 快速排序-范例
 * @param {number []} arr
 * @param {number} left
 * @param {number} right
 * @returns {number []}
 */
var quickSortExample = function (arr, begin, end) {
  let partitionIndex
  const left = typeof begin === 'number' ? begin : 0
  const right = typeof end === 'number' ? end : arr.length - 1
  if (left < right) {
    partitionIndex = partitionExample(arr, left, right)
    quickSortExample(arr, left, partitionIndex - 1)
    quickSortExample(arr, partitionIndex + 1, right)
  }
  return arr
}

function partitionExample (arr, left, right) {
  const pivot = left
  let index = pivot + 1
  for (let i = index; i <= right; i++) {
    if (arr[i] < arr[pivot]) {
      const temp = arr[i]; arr[i] = arr[index]; arr[index] = temp
      index++
    }
  }
  const temp = arr[pivot]; arr[pivot] = arr[index - 1]; arr[index - 1] = temp
  return index - 1
}

var mergeSort = function (arr, left, right) {
  typeof left !== 'number' ? left = 0 : ''
  typeof right !== 'number' ? right = arr.length - 1 : ''
  if (left < right) {
    const mid = (left + right) >> 1
    mergeSort(arr, left, mid)
    mergeSort(arr, mid + 1, right)
    merge(arr, left, mid, right)
  }
  return arr
}

function merge (arr, left, mid, right) {
  const newArr = []
  let i = left; let j = mid + 1; let k = 0
  while (i <= mid && j <= right) {
    newArr[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++]
  }
  while (i <= mid) {
    newArr[k++] = arr[i++]
  }
  while (j <= right) {
    newArr[k++] = arr[j++]
  }

  for (let p = 0; p < newArr.length; p++) {
    arr[left + p] = newArr[p]
  }
}

module.exports = { bubblingSort, selectSort, selectionSortExample, quickSort, quickSortExample, mergeSort }
