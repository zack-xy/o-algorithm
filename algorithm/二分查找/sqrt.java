package algorithm.二分查找;

/**
 *
 * 剑指offer题目：
 *
 *  实现函数int sqrt(int x)计算并返回x的平方根
 *
 */

public class sqrt {

    public int sqrt(int x) {
        int l=1,r=x;
        while(l<=r) {
            int mid=l+((r-l)>>1);
            if (x/mid > mid) {
                l = mid+1;
            } else if (x / mid < mid) {
                r = mid-1;
            } else if (x/mid == mid) {
                return mid;
            }
        }
        return r;
    }
}
