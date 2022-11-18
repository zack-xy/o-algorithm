// 多指针
// P指针索引指的是乘primes相应位置的质数
// P指针的值指的是乘到这个质数的位置
function nthSuperUglyNumber(n: number, primes: number[]): number {
  const p:number[] = Array.from({length: primes.length}, ()=>0)
  const data:number[] = []
  data.push(1)
  let ans: number = 1
  while(data.length !== n) {
    ans = primes[0] * data[p[0]]
    for(let i=1;i<primes.length;i++) {
      ans = Math.min(ans, primes[i] * data[p[i]])
    }
    for(let i=0;i<primes.length;i++) {
      if(primes[i] * data[p[i]] === ans) p[i]++
    }
    data.push(ans)
  }
  return ans
};
