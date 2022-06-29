/**
 * @param {number[]} bills
 * @return {boolean}
 */
// eslint-disable-next-line @typescript-eslint/no-unused-vars
const lemonadeChange = function (bills) {
  let canChange = true
  let fiveNum = 0
  let tenNum = 0
  // let twentyNum = 0
  for (let i = 0; i < bills.length; i++) {
    if (bills[i] === 5)
      fiveNum++
    if (bills[i] === 10) {
      // 找5块
      tenNum++
      if (fiveNum === 0)
        canChange = false

      else
        fiveNum--
    }
    if (bills[i] === 20) {
      // 找15，优先10+5，其次5+5
      // twentyNum++
      if (tenNum === 0) {
        if (fiveNum < 3)
          canChange = false

        else
          fiveNum -= 3
      }
      else {
        tenNum -= 1
        if (fiveNum === 0)
          canChange = false

        else
          fiveNum -= 1
      }
    }
    if (!canChange)
      break
  }
  return canChange
}
