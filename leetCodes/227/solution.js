/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string} s
 * @return {number}
 */
const level = function (c) {
  switch (c) {
    case '@': return -1
    case '+':
    case '-': return 1
    case '*':
    case '/': return 2
  }
  return 0
}

const calc = function (a, op, b) {
  switch (op) {
    case '+': return a + b
    case '-': return a - b
    case '*': return a * b
    case '/': return Math.floor(a / b)
  }
  return 0
}
const calculate = function (s) {
  const nums = []
  const ops = []
  s += '@'
  for (let i = 0, n = 0; i < s.length; i++) {
    if (s[i] === ' ')
      continue
    if (level(s[i]) === 0) {
      n = n * 10 + s[i] * 1
      continue
    }
    nums.unshift(n)
    n = 0
    while (ops.length > 0 && level(s[i]) <= level(ops[0])) {
      const b = nums[0]
      nums.shift()
      const a = nums[0]
      nums.shift()
      nums.unshift(calc(a, ops[0], b))
      ops.shift()
    }
    ops.unshift(s[i])
  }
  return nums[0]
}

