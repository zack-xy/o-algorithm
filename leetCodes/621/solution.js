/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
// 1. 如果冷却时间填满，则时间为任务数量
// 2. 如果冷却时间无法填满，则时间为： 出现最多次数任务n次，m种任务出现n次，冷却时间k
// 如果任务数量大于冷却时间，则一定会填满，应该取1，2最大值
// (n-1)*(k+1)+m
/**
 *
 * A [B] [C]
 * A [B] []
 * A [B] []
 * A B
 */
const leastInterval = function (tasks, n) {
  const cnt = '0'.repeat(26).split('').map(item => item * 1)
  for (let i = 0; i < tasks.length; i++) {
    const idx = tasks[i].charCodeAt() - 65
    cnt[idx]++
  }
  cnt.sort((a, b) => a - b)
  let m = 0
  for (let i = 25; i >= 0 && cnt[i] === cnt[25]; i--, m++);
  return Math.max(tasks.length, (cnt[25] - 1) * (n + 1) + m)
}
