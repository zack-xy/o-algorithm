interface MidFun {
  (a: number, b: number, c: number): number
}

const swap = (x: number, y: number, inArr?: number[]) => {
  const temp = inArr ? inArr[x] : x
  if (inArr) {
    inArr[x] = inArr[y]
    inArr[y] = temp
  }
  else {
    x = y
    y = temp
  }
}

const threshold = 16

const getMid: MidFun = (a, b, c) => {
  if (a > b)
    swap(a, b)
  if (a > c)
    swap(a, c)
  if (b > c)
    swap(b, c)
  return b
}

function __quickSort4(arr: number[], l: number, r: number): void {
  while (r - l > threshold) {
    let x = l
    let y = r
    const base = getMid(arr[l], arr[Math.floor((l + r) / 2)], arr[r])
    do {
      while (arr[x] < base) x++
      while (arr[y] > base) y--
      if (x <= y) {
        swap(x, y, arr)
        x++
        y--
      }
    } while (x <= y)
    __quickSort4(arr, x, r)
    r = y
  }
}

function finalInsertSort(arr: number[], l: number, r: number): void {
  let ind = l
  for (let i = l + 1; i <= r; i++) {
    if (arr[i] < arr[ind])
      ind = i
  }
  while (ind > l) {
    swap(ind, ind - 1, arr)
    ind--
  }
  for (let i = l + 2; i <= r; i++) {
    let j = i
    while (arr[j] < arr[j - 1]) {
      swap(j, j - 1, arr)
      j--
    }
  }
}

// 避免数组元素有序的时候快速排序退化
function quickSort4(arr: number[], l: number, r: number): void {
  __quickSort4(arr, l, r)
  finalInsertSort(arr, l, r)
}

export { quickSort4 }

