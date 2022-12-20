function getMid(a: number, b: number, c: number): number {
  const big = Math.max(a, b, c)
  if (a === big)
    return b > c ? b : c
  if (b === big)
    return a > c ? a : c
  if (c === big)
    return a > b ? a : b
}

function quickSelect(arr: number[], l: number, r: number, k: number): void {
  if (l >= r)
    return
  let x = l
  let y = r
  const mid = getMid(arr[l], arr[Math.floor((l + r) / 2)], arr[r])
  do {
    while (arr[x] < mid) x++
    while (arr[y] > mid) y--
    if (x <= y) {
      const temp = arr[x]
      arr[x] = arr[y]
      arr[y] = temp
      x++
      y--
    }
  } while (x <= y)
  if (y - l === k - 1)
    return // 左区间数量等于k，直接返回
  if (y - l >= k) { // 左区间数量大于k，继续扩大
    quickSelect(arr, l, y, k)
  }
  else {
    quickSelect(arr, x, r, k - x + l)
  }
}

function smallestK(arr: number[], k: number): number[] {
  const ans: number[] = []
  if (k === 0)
    return ans
  quickSelect(arr, 0, arr.length - 1, k)
  while (k) ans.push(arr[--k])
  return ans
}
