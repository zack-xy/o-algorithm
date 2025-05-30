package algorithm.贪心算法;

/**
 *
 * [135. 分发糖果](https://leetcode.cn/problems/candy/description/)
 *
 */
public class candy {

    // 解法一：左右走两遍
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        for (int i=1;i<ratings.length;i++){
            if (ratings[i] > ratings[i-1]) {
                candyVec[i] = candyVec[i-1] + 1;
            } else {
                candyVec[i] = 1;
            }
        }
        for (int i=ratings.length-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i+1] + 1);
            }
        }
        int ans = 0;
        for (int s : candyVec) {
            ans += s;
        }
        return ans;
    }

}
