package algorithm.字符串.反转问题;

public class reverseStr {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i=0;i<n;i+=2*k) {
            reverse(arr, i, Math.min(i+k, n) - 1);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
