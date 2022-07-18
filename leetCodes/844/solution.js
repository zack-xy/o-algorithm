/* eslint-disable @typescript-eslint/no-unused-vars */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

const transform = function (s, S) {
  for (let i = 0; i < s.length; i++) {
    if (s[i] === '#')
      S.pop()
    if (s[i] !== '#')
      S.push(s[i])
  }
}

const backspaceCompare = function (s, t) {
  const S = []
  const T = []
  transform(s, S)
  transform(t, T)
  if (S.length !== T.length)
    return false
  while (S.length > 0) {
    if (S[0] !== T[0])
      return false
    S.pop()
    T.pop()
  }
  return true
}

