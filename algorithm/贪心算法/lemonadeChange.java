package algorithm.贪心算法;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * [860. 柠檬水找零](https://leetcode.cn/problems/lemonade-change/description/)
 *
 */
public class lemonadeChange {

    // 我的代码
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) map.put(bill, map.getOrDefault(bill, 0) + 1);
            if (bill == 10) {
                if (map.containsKey(5) && map.get(5) > 0) {
                    map.put(5, map.get(5) - 1);
                    map.put(bill, map.getOrDefault(bill, 0) + 1);
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (map.containsKey(10) && map.get(10) > 0) {
                    map.put(10, map.get(10) - 1);
                    if (map.containsKey(5) && map.get(5) > 0) {
                        map.put(5, map.get(5) - 1);
                    } else {
                        return false;
                    }
                } else {
                    if (map.containsKey(5) && map.get(5) >= 3) {
                        map.put(5, map.get(5) - 3);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    // 别人的代码
    public boolean lemonadeChange2(int[] bills) {
        // 这里表示5元和10元纸币的数量，不是总金额
        int cash_5 = 0;
        int cash_10 = 0;
        for (int i=0; i<bills.length; i++) {
            if (bills[i] == 5) cash_5++;
            else if (bills[i] == 10) {
                cash_5--;
                cash_10++;
            } else if (bills[i] == 20) {
                if (cash_10 > 0) {
                    cash_10--;
                    cash_5--;
                } else {
                    cash_5 -= 3;
                }
            }
            if (cash_5 < 0 || cash_10 < 0) return false;
        }
        return true;
    }

}
