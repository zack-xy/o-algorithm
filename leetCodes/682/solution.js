/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string[]} ops
 * @return {number}
 */
const calPoints = function (ops) {
  const stack = []
  ops.forEach((item) => {
    if (isNaN(Number(item))) {
      switch (item) {
        case '+':
          stack.push(Number(stack[stack.length - 1]) + Number(stack[stack.length - 2]))
          break
        case 'D':
          stack.push(Number(stack[stack.length - 1]) * 2)
          break
        case 'C':
          stack.pop()
          break
      }
    }
    else {
      stack.push(item)
    }
  })
  return stack.reduce((total, curr) => { return total * 1 + curr * 1 }, 0)
}
