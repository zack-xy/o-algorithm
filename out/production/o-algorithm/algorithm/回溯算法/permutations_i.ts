// 输入一个整数数组，其中不包含重复元素，返回所有可能的排列

// 回溯算法：全排列 I
function backtrack(
  state: number[],
  choices: number[],
  selected: boolean[],
  res: number[][]
): void {
  // 当状态长度等于元素数量时，记录解
  if(state.length === choices.length) {
    res.push([...state]);
    return;
  }
  // 遍历所有选择
  choices.forEach((choice, i) => {
    // 剪枝：不允许重复选择元素
    if(!selected[i]) {
      // 尝试：做出选择，更新状态
      selected[i] = true;
      state.push(choice);
      // 进行下一轮选择
      backtrack(state, choices, selected, res);
      // 回退：撤销选择，恢复到之前的状态
      selected[i] = false;
      state.pop();
    }
  })
}


// 全排列 I
function permutationI(nums: number[]): number[][] {
  const res: number[][] = [];
  backtrack([], nums, Array(nums.length).fill(false), res);
  return res;
}
