function quickSort(arr: number[],l?: number, r?: number):number[] {
  if(l === undefined) l = 0
  if(r === undefined) r = arr.length - 1
  if(l >= r) return arr
  let x = l,y=r,base = arr[l]
  while(x<y) {
    while(x<y && arr[y] >= base) y--
    if(x < y) arr[x++] = arr[y]
    while(x<y && arr[x] < base) x++
    if(x < y) arr[y--] = arr[x]
  }
  arr[x] = base
  quickSort(arr, l, x-1)
  quickSort(arr, x+1, r)
  return arr
} 


