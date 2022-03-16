/**
 * @param {number} n
 * @return {boolean}
 */
// 链表思维，1看待为链表null空地址，有环，则说明不是快乐数
var isHappy = function (n) {
  let p = n;
  let q = n;
  do {
    p = getNext(p);
    q = getNext(getNext(q));
  } while (p != q && q != 1);
  return q == 1;
};

function getNext (x) {
  let z = 0;
  while (x) {
    z += (x % 10) * (x % 10);
    x = Math.floor(x / 10);
  }
  return z;
}
