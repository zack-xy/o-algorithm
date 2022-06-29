/**
 * @param {number} k
 * @return {number}
 */
// eslint-disable-next-line @typescript-eslint/no-unused-vars
const getKthMagicNumber = function (k) {
  const queue = []
  queue.push(1)
  let p3 = 0; let p5 = 0; let p7 = 0
  while (queue.length < k) {
    const ans = Math.min(3 * queue[p3], 5 * queue[p5], 7 * queue[p7])
    if (3 * queue[p3] === ans)
      p3++
    if (5 * queue[p5] === ans)
      p5++
    if (7 * queue[p7] === ans)
      p7++
    queue.push(ans)
  }
  return queue[k - 1]
}
