/**
 * 计算表达式的值
 * 1. 找到最低优先级运算符
 * @string s
 */
function calc(s, l, r) {
  let op = -1 // 最低优先级运算符的位置
  let pri = 10000 - 1 // 计算运算符的优先级
  let curPri = null
  let temp = 0
  for (let i = l; i <= r; i++) {
    curPri = 10000
    switch (s[i]) {
      case '+':
      case '-':
        curPri = 1 + temp
        break
      case '*':
      case '/':
        curPri = 2 + temp
        break
      case '(':
        temp += 100
        break
      case ')':
        temp -= 100
        break
    }
    if (curPri <= pri) {
      pri = curPri
      op = i
    }
  }
  if (op === -1) {
    let num = ''
    for (let i = l; i <= r; i++) {
      if (isNaN(Number(s[i])) && s[i] !== '.')
        continue
      num += s[i]
    }
    return Number(num)
  }
  console.log('优先级最小的符号是：', s[op])
  const a = calc(s, l, op - 1)
  const b = calc(s, op + 1, r)
  switch (s[op]) {
    case '+': return a + b
    case '-': return a - b
    case '*': return a * b
    case '/': return a / b
  }
}
