/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
// eslint-disable-next-line @typescript-eslint/no-unused-vars
const leastInterval = function (tasks, n) {
  let cnt = {}
  for (let i = 0; i < tasks.length; i++) {
    if (!cnt[tasks[i]])
      cnt[tasks[i]] = 0
    cnt[tasks[i]] += 1
  }
  cnt = Object.values(cnt).sort()
  let m = 0
  for (let i = cnt.length - 1; i >= 0 && cnt[i] === cnt[cnt.length - 1]; i--, m++);
  return Math.max(tasks.length, (cnt[cnt.length - 1] - 1) * (n - 1) + m)
}
