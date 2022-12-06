// 节省递归层数
// 节省递归开辟的栈空间
function quickSort2(arr: number[], l:number, r:number): void {
  while(l < r) {
    let x = l,y=r,base=arr[l]
    while(x<y) {
      while(x<y && arr[y]>=base) y--
      if(x<y) arr[x++] = arr[y]
      while(x<y && arr[x] < base) x++
      if(x<y) arr[y--] = arr[x]
    }
    arr[x] = base
    quickSort2(arr, x+1, r)
    r = x - 1
  }
  return
}
