// 构造链表的第2种方式
// 两个数组映射

let data = new Array(); // 数据域
let next = new Array(); // 指针域

// idx是next数组的索引，next中存的是data的索引（相对地址）
// p是data的索引，val是data中存储的值
function add (idx, p, val) {
  next[idx] = p;
  data[p] = val;
}

let head = 3;
data[3] = 0;
add(3, 5, 1);
add(5, 2, 2);
add(2, 7, 3);
add(7, 9, 100);


let str = ""
let p = head
while (p != null || p != undefined) {
  str += `${data[p]}->`
  p = next[p]
}

console.log(str);  // 0->1->2->3->100->
