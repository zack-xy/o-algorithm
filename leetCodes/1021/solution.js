/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string} s
 * @return {string}
 */
// 计算左右括号数量差值，差值为0处是原语
// 其实差值就是栈顶指针
const removeOuterParentheses = function (s) {
  let ret = ''
  for (let i = 0, pre = 0, cnt = 0; i < s.length; i++) {
    if (s[i] === '(')
      cnt += 1
    else cnt -= 1
    if (cnt !== 0)
      continue
    ret += s.substr(pre + 1, i - pre - 1)
    pre = i + 1
  }
  return ret
}
