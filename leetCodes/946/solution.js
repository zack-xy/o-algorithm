/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {number[]} pushed
 * @param {number[]} popped
 * @return {boolean}
 */
// 只看出栈
// 1. 元素在当前栈顶，弹出即可
// 2. 元素还未入栈，入栈到栈顶即可
const validateStackSequences = function (pushed, popped) {
  const s = []
  for (let i = 0, j = 0; i < popped.length; i++) {
    while (j < pushed.length && (s.length === 0 || s[0] !== popped[i])) {
      s.unshift(pushed[j])
      j++
    }
    if (s[0] !== popped[i])
      return false
    s.shift()
  }
  return true
}
