package algorithm.回溯算法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * [77. 组合](https://leetcode.cn/problems/combinations/description/)
 *
 */
public class combine {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0 || n<k) return res;
        // 用户返回结果
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    // 递归
    /**
     *
     * @param n
     * @param k
     * @param startIndex 起始数
     * @param path  路径
     * @param resultList 结果
     */
    public static void dfs(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resultList) {
        // 递归终止条件是：path的长度等于k
        if (path.size() == k) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 针对一个节点，遍历可能的搜索起点，其实就是枚举
        for (int i = startIndex; i <= n; i++) {
            // 向路径变量里添加一个数，就是上图中的一个树枝的值
            path.addLast(i);
            // 搜索起点要加1是为了缩小范围，下一轮递归做准备，因为不允许出现重复的元素
            dfs(n,k,i+1,path,resultList);
            // 递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        // n = 4, k =2
        // [1,4]中选2个数
        List<List<Integer>> ret = combine(4, 2);
        System.out.println(ret.toString());
    }

}
