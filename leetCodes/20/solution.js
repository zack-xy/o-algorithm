/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string} s
 * @return {boolean}
 */
const isValid = function (s) {
  const stack = []
  for (let i = 0; i < s.length; i++) {
    switch (s[i]) {
      case '(':
      case '[':
      case '{':
        stack.unshift(s[i])
        break
      case ')':
        if (stack.length === 0 || stack[0] !== '(')
          return false
        stack.shift()
        break
      case ']':
        if (stack.length === 0 || stack[0] !== '[')
          return false
        stack.shift()
        break
      case '}':
        if (stack.length === 0 || stack[0] !== '{')
          return false
        stack.shift()
        break
    }
  }
  return stack.length === 0
}
