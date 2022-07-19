/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string} s
 * @return {string}
 */
const minRemoveToMakeValid = function (s) {
  // 去掉多余右括号
  let t = ''
  for (let i = 0, cnt = 0; i < s.length; i++) {
    if (s[i] === '(' || s[i] !== ')') {
      cnt += s[i] === '(' ? 1 : 0
      t += s[i]
    }
    else {
      if (cnt === 0)
        continue
      cnt -= 1
      t += ')'
    }
  }
  // 去掉多余左括号
  let t2 = ''
  for (let i = t.length - 1, cnt = 0; i >= 0; i--) {
    if (t[i] === ')' || t[i] !== '(') {
      cnt += t[i] === ')' ? 1 : 0
      t2 = t[i] + t2
    }
    else {
      if (cnt === 0)
        continue
      cnt -= 1
      t2 = `(${t2}`
    }
  }
  return t2
}
