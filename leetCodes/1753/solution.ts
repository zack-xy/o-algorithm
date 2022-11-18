// 排序从小到大：a,b,c
// a中消减c-b部分
// a中均分在b、c中消减
// b向c中消减
function maximumScore(a: number, b: number, c: number): number {
  let [a1,b1,c1] = [a,b,c].sort((m,n)=>m-n)
  let ans = 0
  // step1
  const cnt1 = Math.min(c1-b1, a1)
  a1-=cnt1
  c-=cnt1
  ans+=cnt1
  // step2

  if(a1!==0) {
    if(a1 % 2 !== 0) a1 -= 1
    b1 -= a1 / 2
    c1 -= a1 / 2
    ans += a1
  }

  // step3
  ans+=b1
  return ans
};
