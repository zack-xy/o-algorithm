package algorithm.贪心算法;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * [763. 划分字母区间](https://leetcode.cn/problems/partition-labels/description/)
 *
 * 老实说，第一遍连题目都没看懂，题目的意思是，同一个字母不能出现在2个片段中
 * 再翻译就是2个片段中，不能有相同的字母
 *
 */
public class partitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();  // 结果列表，里面的数据代表字符片段的长度
        int[] edge = new int[26];  // 记录字母最后出现的索引位置
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;  // 为什么要在外部定义idx?
        int last = -1;  // 为什么要定义一个last？为什么定义为-1？ // 也可以定义为0，下面 list.add(i - last + 1);last = i + 1;
        // 开启循环
        for (int i=0;i<chars.length;i++) {
            // 相当于在一系列字符串中，找出来标记的索引最远的
            // 也就是在一堆最远的索引里找最远的
            idx = Math.max(idx, edge[chars[i] - 'a']);
            // 代码运行到这里，当前这个索引和最远的索引相等
            // 代表这找到了这个最远的字符
            // 片段应该从这里断开
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

}
