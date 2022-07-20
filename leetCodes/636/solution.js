/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {number} n
 * @param {string[]} logs
 * @return {number[]}
 */
const exclusiveTime = function (n, logs) {
  const ans = []
  const vID = []
  for (let i = 0, pre = 0; i < logs.length; i++) {
    const infos = logs && logs[i].split(':')
    const id = Number(infos[0])
    const status = infos[1]
    const time = Number(infos[2])
    if (status === 'start') {
      if (vID.length > 0)
        ans[vID[0]] = ans[vID[0]] ? ans[vID[0]] + (time - pre) : time - pre

      pre = time
      vID.unshift(id)
    }
    else {
      ans[id] = ans[id] ? ans[id] + (time - pre + 1) : time - pre + 1
      pre = time + 1
      vID.shift()
    }
  }
  return ans
}
