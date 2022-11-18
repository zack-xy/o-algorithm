function isUgly(n: number): boolean {
  if(n <= 0) return false
  let absN = Math.abs(n)
  if(absN < 2) return true
  while(absN !== 1 && (absN % 2 === 0 || absN % 3 === 0 || absN % 5 === 0)) {
    if(absN % 2 === 0) {
      absN = absN / 2
    }
    if(absN % 3 === 0) {
      absN = absN / 3
    }
    if(absN % 5 === 0) {
      absN = absN / 5
    }
  }
  return absN === 1
};
