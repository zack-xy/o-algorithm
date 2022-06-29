const hasRepeat = function (s) {
  const cnt = {}
  let hasRepeat = false
  for (let i = 0; s[i]; i++) {
    if (!cnt[s[i]])
      cnt[s[i]] = 0
    cnt[s[i]]++
    if (cnt[s[i]] === 2) {
      hasRepeat = true
      break
    }
  }
  return hasRepeat
}

/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
// 满足相同的一段，不同的2位置互换可相同，其余是相同的
// eslint-disable-next-line @typescript-eslint/no-unused-vars
const buddyStrings = function (s, goal) {
  if (s.length !== goal.length)
    return false
  if (s === goal)
    return hasRepeat(s)
  let i = 0; let j = 0
  while (s[i] === goal[i]) ++i
  j = i + 1
  while (j < s.length && s[j] === goal[j]) ++j
  if (j === s.length)
    return false
  if (s[i] !== goal[j] || s[j] !== goal[i])
    return false
  j += 1
  while (j < s.length) {
    if (s[j] !== goal[j])
      return false
    j += 1
  }
  return true
}
