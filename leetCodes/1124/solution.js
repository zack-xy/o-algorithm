/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {number[]} hours
 * @return {number}
 */
// 这里可以使用【前缀和】思想
// 【前缀和】可以方便的求取任意区间的区间和
// 这里将原序列转化为形如1 -1 1的序列
// 原问题转化为求取区间和大于0的区间
// 即使用前缀和求取大于0的区间
// 相当于前缀和数组中找到两项相减大于0且区间最长
// 又因为 前缀和数组是连续的
// f(n-1)以n-1结尾的最长序列长度
// f(n) = f(n-1) + (p(n) - P(n-1))
const longestWPI = function (hours) {
  const ind = {}
  const f = {}
  let cnt = 0; let ans = 0
  ind[0] = -1
  f[0] = 0
  for (let i = 0; i < hours.length; i++) {
    if (hours[i] > 8)
      cnt += 1
    else cnt -= 1
    if (ind[cnt] === undefined) {
      ind[cnt] = i
      if (ind[cnt - 1] === undefined)
        f[cnt] = 0

      else
        f[cnt] = f[cnt - 1] + (i - ind[cnt - 1])
    }
    if (ind[cnt - 1] === undefined)
      continue
    ans = Math.max(ans, i - ind[cnt - 1] + f[cnt - 1])
  }
  return ans
}
