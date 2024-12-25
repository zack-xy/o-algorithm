// 移动一个圆盘
function move(src: number[], tar: number[]) {
  // 从src顶部拿出一个圆盘
  const pan = src.pop()!;
  // 将圆盘放入tar顶部
  tar.push(pan);
}


// 求解汉诺塔问题 f(i)
function dfs(i: number, src: number[], buf: number[], tar: number[]): void {
  // 若 src 只剩下一个圆盘，则直接将其移到 tar
  if(i === 1) {
    move(src, tar);
    return;
  }
  // 子问题 f(i-1): 将src顶部 i-1个圆盘借助tar移动到buf
  dfs(i-1, src, tar, buf);
  // 子问题 f(1): 将src剩余一个圆盘移到tar
  move(src, tar);
  // 子问题f(i-1): 将buf顶部i-1个圆盘借助src移到tar
  dfs(i-1, buf, src, tar);
}

// 求解汉诺塔问题
function solveHanota(A: number[], B: number[], C: number[]): void {
  const n = A.length;
  // 将 A 顶部 n 个圆盘借助 B 移到 C
  dfs(n, A, B, C);
}

export { solveHanota }
