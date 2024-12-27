// 给定一个正整数数组nums和一个目标正整数target，请找出所有可能的组合，使得组合中的元素和等于target。给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合

// 简版 - 包含重复组合
// 回溯算法
function backtrack(
  state: number[],
  target: number,
  total: number,
  choices: number[],
  res: number[][]
): void {
  // 子集和等于target时，记录解
  if(total === target) {
    res.push([...state]);
    return;
  }
  // 遍历所有选择
  for(let i=0;i<choices.length;i++) {
    // 剪枝：若子集和超过target，则跳过该选择
    if(total + choices[i] > target) {
      continue;
    }
    // 尝试：做出选择，更新元素和total
    state.push(choices[i]);
    // 进行下一轮选择
    backtrack(state, target, total + choices[i], choices, res);
    // 回退：撤销选择，恢复到之前的状态
    state.pop();
  }
}


// 求解子集和（包含重复子集）
function subsetSumINaive(nums: number[], target: number): number[][] {
  const state = []; // 状态（子集）
  const total = 0; // 子集和
  const res: number[][] = []; // 结果列表 (子集列表)
  backtrack(state, target, total, nums, res);
  return res;
}
