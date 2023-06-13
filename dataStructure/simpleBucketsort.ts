// 排序0-10
// 申请长度为11的数组，arr[0]处存储0的个数，依次类推
// arr只包含0-10的数字

// eslint-disable-next-line @typescript-eslint/no-unused-vars
function simpleBucketSort(arr: number[]): void {
  const a = new Array<number>(11)
  for (let i = 0; i <= 10; i++)
    a[i] = 0 // 初始化为0
  // 循环输入的arr
  for (let i = 0; i < arr.length; i++)
    a[arr[i]]++
  // 循环a，出现几次就打印几次
  for (let i = 0; i < a.length; i++) {
    for (let j = 1; j < a[i]; j++)
      // eslint-disable-next-line no-console
      console.log(' ', i)
  }
}
