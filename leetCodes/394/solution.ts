// eslint-disable-next-line @typescript-eslint/no-unused-vars
function decodeString(s: string): string {
  let ret = ''
  let i = 0
  while (s[i]) {
    if (s[i] < '0' || s[i] > '9') {
      ret += s[i]
      i++
    }
    else {
      let num = 0
      while (s[i] >= '0' && s[i] <= '9')
        num = num * 10 + Number(s[i++])

      i++
      const l = i
      let r = i
      let cnt = 1
      while (cnt) {
        r += 1
        if (s[r] === '[')
          cnt++
        else if (s[r] === ']')
          cnt--
      }
      const tmp = decodeString(s.substr(l, r - l))
      while (num--) ret += tmp
      i = r + 1
    }
  }
  return ret
}
